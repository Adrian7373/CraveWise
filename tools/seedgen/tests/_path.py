"""Puts tools/seedgen on sys.path so tests can `import seedgen` (stdlib unittest, no install)."""
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
if str(ROOT) not in sys.path:
    sys.path.insert(0, str(ROOT))

import seedgen  # noqa: E402,F401
