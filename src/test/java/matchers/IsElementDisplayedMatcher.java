package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;


public class IsElementDisplayedMatcher extends TypeSafeMatcher<WebElement> {


    @Override
    protected boolean matchesSafely(WebElement element) {


        return element.isDisplayed();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("element is displayed");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("element ").appendValue(element).appendText(" is not displayed");
    }


    @Factory
    public static Matcher<WebElement> isDisplayed() {
        return new IsElementDisplayedMatcher();
    }
}

