package com.jd.dailyplanet;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.jd.dailyplanet.ui.NewsListFragment;
import com.jd.dailyplanet.ui.SplashFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

  TestNavHostController navController;

  @Before
  public void setup() {
    navController = new TestNavHostController(
      ApplicationProvider.getApplicationContext());
    navController.setGraph(R.navigation.nav_graph);
  }

  @Test
  public void testNavigationToSplashFragment() {
    FragmentScenario<SplashFragment> splashFragmentScenario =
      FragmentScenario.launchInContainer(SplashFragment.class);

    splashFragmentScenario.onFragment(fragment ->
      Navigation.setViewNavController(fragment.requireView(), navController));

    assertThat(navController.getCurrentDestination().getId(), is(equalTo(R.id.splashFragment)));
  }

  @Test
  public void testNavigationNewsListFragment() {
    FragmentScenario<SplashFragment> splashFragmentScenario =
      FragmentScenario.launchInContainer(SplashFragment.class);

    splashFragmentScenario.onFragment(fragment -> {
      Navigation.setViewNavController(fragment.requireView(), navController);
      fragment.goToNewsListFragment(fragment.requireView());
    });

    assertThat(navController.getCurrentDestination().getId(), is(equalTo(R.id.newsListFragment)));
  }

  @Ignore
  @Test
  public void testNavigationNewsDetailsFragment() {
    FragmentScenario<NewsListFragment> newsListFragmentFragmentScenario
      = FragmentScenario.launchInContainer(NewsListFragment.class);

    newsListFragmentFragmentScenario.onFragment(fragment -> {
      Navigation.setViewNavController(fragment.requireView(), navController);
      fragment.goToNewsDetailsFragment(fragment.requireView());
    });

    // onView(withId(R.id.newsListScreen)).perform(click());
    assertThat(navController.getCurrentDestination().getId(), is(equalTo(R.id.newsDetailsFragment)));
  }

  @After
  public void cleanup() {
    navController = null;
  }
}
