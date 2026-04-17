package com.example.myfirstapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit4.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun loginScreen_isDisplayed() {
        composeTestRule.onNodeWithTag("loginTitle").assertIsDisplayed()
        composeTestRule.onNodeWithTag("usernameField").assertIsDisplayed()
        composeTestRule.onNodeWithTag("passwordField").assertIsDisplayed()
        composeTestRule.onNodeWithTag("loginButton").assertIsDisplayed()
    }

    @Test
    fun login_withInvalidCredentials_showsError() {
        composeTestRule.onNodeWithTag("usernameField").performTextInput("wrong")
        composeTestRule.onNodeWithTag("passwordField").performTextInput("wrong")
        composeTestRule.onNodeWithTag("loginButton").performClick()
        composeTestRule.onNodeWithTag("errorText").assertIsDisplayed()
    }

    @Test
    fun login_withValidCredentials_navigatesToHome() {
        composeTestRule.onNodeWithTag("usernameField").performTextInput("admin")
        composeTestRule.onNodeWithTag("passwordField").performTextInput("password123")
        composeTestRule.onNodeWithTag("loginButton").performClick()
        composeTestRule.onNodeWithTag("welcomeText").assertIsDisplayed()
    }

    @Test
    fun counter_incrementAndDecrement() {
        composeTestRule.onNodeWithTag("usernameField").performTextInput("admin")
        composeTestRule.onNodeWithTag("passwordField").performTextInput("password123")
        composeTestRule.onNodeWithTag("loginButton").performClick()

        composeTestRule.onNodeWithTag("counterValue").assertTextEquals("0")
        composeTestRule.onNodeWithTag("incrementButton").performClick()
        composeTestRule.onNodeWithTag("counterValue").assertTextEquals("1")
        composeTestRule.onNodeWithTag("decrementButton").performClick()
        composeTestRule.onNodeWithTag("counterValue").assertTextEquals("0")
    }

    @Test
    fun logout_returnsToLoginScreen() {
        composeTestRule.onNodeWithTag("usernameField").performTextInput("admin")
        composeTestRule.onNodeWithTag("passwordField").performTextInput("password123")
        composeTestRule.onNodeWithTag("loginButton").performClick()
        composeTestRule.onNodeWithTag("logoutButton").performClick()
        composeTestRule.onNodeWithTag("loginTitle").assertIsDisplayed()
    }
}
