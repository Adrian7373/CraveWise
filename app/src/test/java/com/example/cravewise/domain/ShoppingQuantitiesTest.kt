package com.example.cravewise.domain

import com.example.cravewise.domain.model.MeasureUnit
import com.example.cravewise.domain.model.ShoppingShare
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ShoppingQuantitiesTest {

    private fun share(amount: Double?, unit: MeasureUnit?, raw: String = "", max: Double? = null, recipe: String? = "r") =
        ShoppingShare(recipe, amount, max, unit, raw)

    private fun format(vararg shares: ShoppingShare) = ShoppingQuantities.format(shares.toList())

    @Test fun metricMassSumsAndUpgradesToKg() {
        assertEquals("1.2 kg", format(share(200.0, MeasureUnit.G), share(1.0, MeasureUnit.Kg)))
        assertEquals("450 g", format(share(200.0, MeasureUnit.G), share(250.0, MeasureUnit.G)))
    }

    @Test fun imperialMassStaysImperial() {
        assertEquals("12 oz", format(share(8.0, MeasureUnit.Oz), share(4.0, MeasureUnit.Oz)))
        assertEquals("1½ lb", format(share(1.0, MeasureUnit.Lb), share(8.0, MeasureUnit.Oz)))
    }

    @Test fun mixedMetricAndImperialMassGoesMetric() {
        assertEquals("328 g", format(share(300.0, MeasureUnit.G), share(1.0, MeasureUnit.Oz)))
    }

    @Test fun spoonsAndCupsPickAReadableUnit() {
        assertEquals("1⅓ tbsp", format(share(1.0, MeasureUnit.Tbsp), share(1.0, MeasureUnit.Tsp)))
        assertEquals("2 tsp", format(share(1.0, MeasureUnit.Tsp), share(1.0, MeasureUnit.Tsp)))
        assertEquals("1 cup", format(share(0.5, MeasureUnit.Cup), share(8.0, MeasureUnit.Tbsp)))
        assertEquals("1½ cups", format(share(1.0, MeasureUnit.Cup), share(0.5, MeasureUnit.Cup)))
    }

    @Test fun metricVolumeUpgradesToLitres() {
        assertEquals("1.25 l", format(share(1.0, MeasureUnit.L), share(250.0, MeasureUnit.Ml)))
        assertEquals("ml wins over spoons when mixed", "265 ml", format(share(250.0, MeasureUnit.Ml), share(1.0, MeasureUnit.Tbsp)))
    }

    @Test fun incompatibleUnitsAreJoined() {
        assertEquals("2 cloves + 1 tbsp", format(share(2.0, MeasureUnit.Clove), share(1.0, MeasureUnit.Tbsp)))
    }

    @Test fun countsSumAndOtherUnitsPluralize() {
        assertEquals("3", format(share(2.0, null), share(1.0, null)))
        assertEquals("1 clove", format(share(1.0, MeasureUnit.Clove)))
        assertEquals("2 pinches", format(share(1.0, MeasureUnit.Pinch), share(1.0, MeasureUnit.Pinch)))
        assertEquals("2 leaves", format(share(2.0, MeasureUnit.Leaf)))
    }

    @Test fun rangesSumBothEnds() {
        assertEquals("3–4 cloves", format(share(2.0, MeasureUnit.Clove, max = 3.0), share(1.0, MeasureUnit.Clove)))
    }

    @Test fun unparsedTextIsAppendedOnce() {
        assertEquals(
            "1 tsp + to taste",
            format(share(1.0, MeasureUnit.Tsp), share(null, null, "To taste"), share(null, null, "to taste")),
        )
    }

    @Test fun manualSharesWithoutAmountShowNothing() {
        assertNull(format(share(null, null, recipe = null)))
        assertEquals("2", format(share(null, null, recipe = null), share(2.0, null)))
    }
}
