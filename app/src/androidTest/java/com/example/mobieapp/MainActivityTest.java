package com.example.mobieapp;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void usernamecheck() {
        onView(withId(R.id.editUser)).perform(typeText("ben"));



        onView(withId(R.id.regester)).perform(scrollTo(), (click()));

        onView(allOf(withId(R.id.editUser),hasErrorText("Must have 6 characters")));

    }
    @Test
    public void fullnamecheck(){
        onView(withId(R.id.editTextName)).perform(typeText("john"));
        onView(withId(R.id.regester)).perform(scrollTo(), (click()));
        onView(allOf(withId(R.id.editTextName), hasErrorText("Must have 8 characters")));

    }
    @Test
    public void emailcheck(){
        onView(withId(R.id.editTextEmail)).perform(typeText("john.gmail"));
        onView(withId(R.id.regester)).perform(scrollTo(), (click()));
        onView(allOf(withId(R.id.editTextEmail), hasErrorText("Email is inValid")));
    }
    public void passwordcheck(){
        onView(withId(R.id.password)).perform(typeText("pass"));
        onView(withId(R.id.regester)).perform(scrollTo(), (click()));
        onView(allOf(withId(R.id.password), hasErrorText("Password must have 8 or more characters")));
    }

    @Test
    public void register(){
        onView(withId(R.id.editUser)).perform(typeText("abe"));
        onView(withId(R.id.editTextName)).perform(typeText("abenezer taddesse"));
        onView(withId(R.id.editTextEmail)).perform(typeText("abe@gmail.com"));

        onView(withId(R.id.password)).perform(typeText("password12"));

    }




}