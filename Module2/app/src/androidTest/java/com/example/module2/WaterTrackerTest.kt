package com.example.module2

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.module2.ui.theme.Module2Theme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            Module2Theme {
                WaterTracker()
            }
        }
    }

    @Test
    fun initialStateIsDisplayed() {
        composeTestRule
            .onNodeWithText("Трекер воды")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("+250 мл")
            .assertIsDisplayed()
            .assertHasClickAction()

        composeTestRule
            .onNodeWithText("Завершить день")
            .assertIsDisplayed()
            .assertHasClickAction()

        composeTestRule
            .onNodeWithText("100 мл")
            .assertIsDisplayed()

        assertSuccessfulDays(0)
    }

    @Test
    fun addWaterButtonIncreasesWaterCount() {
        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()

        composeTestRule
            .onNodeWithText("350 мл")
            .assertIsDisplayed()

        assertSuccessfulDays(0)
    }

    @Test
    fun finishDayResetsWaterCount() {
        composeTestRule
            .onNodeWithText("+250 мл")
            .performClick()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()

        assertSuccessfulDays(0)
    }

    @Test
    fun successfulDayIncreasesDayCount() {
        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("1600 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()

        assertSuccessfulDays(1)
    }

    @Test
    fun consecutiveSuccessfulDaysIncreaseDayCount() {
        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        assertSuccessfulDays(1)

        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("1500 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        assertSuccessfulDays(2)

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()
    }

    @Test
    fun unsuccessfulDayResetsDayCount() {
        repeat(6) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        assertSuccessfulDays(1)

        repeat(5) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("1250 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        assertSuccessfulDays(0)

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()
    }
    @Test
    fun multipleClicksAccumulateWater() {
        repeat(10) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("2600 мл")
            .assertIsDisplayed()

        assertSuccessfulDays(0)
    }

    @Test
    fun exceedingGoalIncreasesDayCount() {
        repeat(7) {
            composeTestRule
                .onNodeWithText("+250 мл")
                .performClick()
        }

        composeTestRule
            .onNodeWithText("1850 мл")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Завершить день")
            .performClick()

        assertSuccessfulDays(1)

        composeTestRule
            .onNodeWithText("0 мл")
            .assertIsDisplayed()
    }
    private fun assertSuccessfulDays(expected: Int) {
        composeTestRule
            .onNodeWithText(
                "Дней подряд с объёмом от 1500 мл: $expected"
            )
            .assertIsDisplayed()
    }
}