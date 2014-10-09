package android.baltazarg.blog_reader;
    public class BlogPostParser {
        private static BlogPostParser parser;

        private BlogPostParser() {

        }
        public static BlogPostParser get() {
            if(parser == null) {
                parser = new BlogPostParser();
            }
            return parser;
        }
}
