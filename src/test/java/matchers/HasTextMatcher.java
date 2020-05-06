package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebElement;


    public class HasTextMatcher extends TypeSafeMatcher<WebElement>{
        private final Matcher<String> textMatcher;
        private HasTextMatcher(Matcher<String> textMatcher) {
            this.textMatcher = textMatcher;
        }

        @Override
        public boolean matchesSafely(WebElement element) {
            return this.textMatcher.matches(element.getText());
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("element has text");
        }

        @Override
        public void describeMismatchSafely(WebElement element, final Description mismatchDescription) {
            mismatchDescription.appendText("element doesn't have next text ").appendValue(textMatcher);
        }


        @Factory
        public static Matcher<WebElement> hasText(String text) {
            return new HasTextMatcher(Is.is(text));
        }


    }



