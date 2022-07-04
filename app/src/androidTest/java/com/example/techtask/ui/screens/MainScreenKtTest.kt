package com.example.techtask.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.techtask.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenKtTest {

    @get :Rule
    val rule = createAndroidComposeRule<MainActivity>()


    @Test
    fun navigate_to_favourites() {
        rule.onNodeWithText("Favourites").performClick()
        rule.onNodeWithTag("Favourite Screen").assertIsDisplayed()
    }
}