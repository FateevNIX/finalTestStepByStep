package matchers;


import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;
import java.util.NoSuchElementException;

public class IsElementDisplayedMatcher extends TypeSafeMatcher<WebElement> {


    @Override
    protected boolean matchesSafely(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException nsee) {
            return false; }
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

