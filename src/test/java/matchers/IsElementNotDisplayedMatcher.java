package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class IsElementNotDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    @Override
    protected boolean matchesSafely(WebElement element) {
        try {
            return !(element.isDisplayed());
        } catch (NoSuchElementException nsee) {
            return false; }
    }
    @Override
    public void describeTo(Description description) {
        description.appendText("element is not displayed");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("element ").appendValue(element).appendText(" is displayed");
    }


    @Factory
    public static Matcher<WebElement> isNotDisplayed() {
        return new IsElementDisplayedMatcher();
    }
}



