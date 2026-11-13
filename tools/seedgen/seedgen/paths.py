"""Every file location the pipeline reads or writes."""
from pathlib import Path

SEEDGEN = Path(__file__).resolve().parent.parent          # tools/seedgen
REPO = SEEDGEN.parent.parent

RAW = SEEDGEN / "raw"
RAW_MEALDB = RAW / "mealdb"            # per-request cache (committed)
RAW_FDC = RAW / "fdc"                  # USDA bulk CSVs (gitignored)

CURATION = SEEDGEN / "curation"
INGREDIENTS = CURATION / "ingredients.json"
INGREDIENTS_REVIEW = CURATION / "ingredients.review.md"
OVERRIDES = CURATION / "overrides.json"
CUISINES = CURATION / "cuisines.json"
EXCLUDE = CURATION / "exclude.json"

TAGS_AI = SEEDGEN / "tags" / "ai"
OUT = SEEDGEN / "out"

APP = REPO / "app" / "src" / "main"
VOCABULARY_KT = APP / "java" / "com" / "example" / "cravewise" / "domain" / "model" / "Vocabulary.kt"
ASSET_DIR = APP / "assets" / "seed"
