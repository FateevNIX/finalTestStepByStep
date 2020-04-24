package matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;


    public class HasTextMatcher extends TypeSafeMatcher<String>{

        private WebElement element;

        @Override
        public boolean matchesSafely(String text) {

            return element.getText().contains(text);
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("element has text");
        }

        @Override
        public void describeMismatchSafely(String text, final Description mismatchDescription) {
            mismatchDescription.appendText("element doesn't have next text ").appendValue(text);
        }


        @Factory
        public static Matcher<String> hasText(String text) {
            return new HasTextMatcher();
        }


    }



