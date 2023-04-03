public class Star {
    public String starring(String rating) {
        var star = "";
        var ratingString = Double.parseDouble(rating);
        var ratingInt = (int) ratingString;
        for (int i = 0; i < ratingInt; i++) {
            star += "\u2B50";
        }
        return star;
    }
}
