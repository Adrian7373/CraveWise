"""Phase B.3: TheMealDB `strInstructions` → clean steps.

Handles "STEP 1" headings, one step per line, lines broken mid-sentence, and steps numbered
inline ("...set aside 2. Drain the..."). Never edits the text inside a step, so durations like
"simmer for 10-15 minutes" survive verbatim for the app's StepTimers.
"""
from __future__ import annotations

import re

_TIME_UNIT = r"(?:hours?|hrs?|minutes?|mins?|seconds?|secs?)\b"
_STEP_HEADING = re.compile(r"\bstep\s*\d+\s*[:.)-]?", re.I)
_INLINE_NUMBER = re.compile(r"\s+\d{1,2}[.)]\s+(?=[A-Z])|(?<=[.!?])\s+\d{1,2}\s+(?=[A-Z])")
_DANGLING_NUMBER = re.compile(r"(?<=[.!?])\s+\d{1,2}\.?$")
_HEADING_ONLY = re.compile(r"^(?:method|directions|instructions|preparation|to serve|for the \w+)\s*:?$", re.I)


def split_steps(text: str) -> list[str]:
    t = (text or "").replace("\r", "").replace(" ", " ")
    if _STEP_HEADING.search(t):
        parts = _STEP_HEADING.split(t)
    else:
        parts, buf = [], ""
        for line in (ln.strip() for ln in t.split("\n")):
            if not line:
                if buf:
                    parts.append(buf)
                    buf = ""
                continue
            buf = f"{buf} {line}".strip()
            if re.search(r"[.!?:)]$", buf):  # sentence ended -> the line break is a real step break
                parts.append(buf)
                buf = ""
        if buf:
            parts.append(buf)
    steps: list[str] = []
    for part in parts:
        for piece in _INLINE_NUMBER.split(part):
            piece = re.sub(r"\s+", " ", piece).strip()
            piece = _strip_leading_number(piece)
            piece = _DANGLING_NUMBER.sub("", piece).strip(" -")
            if not piece or re.fullmatch(r"[\d.\s]*", piece) or _HEADING_ONLY.match(piece):
                continue
            piece = piece if re.search(r"[.!?)]$", piece) else piece + "."
            steps.extend(_split_long(piece))
    return steps


LONG_STEP = 400
TARGET_STEP = 260
_SENTENCE = re.compile(r"(?<=[.!?])\s+(?=[A-Z])")


def _split_long(step: str) -> list[str]:
    """A wall of text (one paragraph for the whole method) becomes steps of a few sentences each."""
    if len(step) <= LONG_STEP:
        return [step]
    out, buf = [], ""
    for sentence in _SENTENCE.split(step):
        if buf and len(buf) + 1 + len(sentence) > TARGET_STEP:
            out.append(buf)
            buf = sentence
        else:
            buf = f"{buf} {sentence}".strip()
    if buf:
        out.append(buf)
    return out


def _strip_leading_number(piece: str) -> str:
    """Drops a leading "1." / "2)" / "3 " before a capital; never "10 minutes later", "2 eggs", "1.5 kg"."""
    m = re.match(r"^(\d{1,2})(?:([.)])(?!\d)\s*|\s+)(.*)$", piece, re.S)
    if not m:
        return piece
    rest = m.group(3)
    if m.group(2):  # "1." / "2)" is always a step number
        return rest
    if rest[:1].isupper() and not re.match(_TIME_UNIT, rest, re.I):
        return rest
    return piece
