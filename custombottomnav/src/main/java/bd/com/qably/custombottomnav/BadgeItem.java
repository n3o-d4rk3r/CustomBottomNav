package bd.com.qably.custombottomnav;


import java.io.Serializable;

class BadgeItem implements Serializable {

    private static final int BADGE_TEXT_MAX_NUMBER = 9;

    private int badgeIndex;

    private int badgeText;

    private int badgeColor;

    BadgeItem(int badgeIndex, int badgeText, int badgeColor) {
        this.badgeIndex = badgeIndex;
        this.badgeText = badgeText;
        this.badgeColor = badgeColor;
    }

    int getBadgeIndex() {
        return badgeIndex;
    }

    int getBadgeColor() {
        return badgeColor;
    }

    int getIntBadgeText() {
        return badgeText;
    }

    String getFullBadgeText() {
        return String.valueOf(badgeText);
    }

    String getBadgeText() {
        String badgeStringText;
        if (badgeText > BADGE_TEXT_MAX_NUMBER) {
            badgeStringText = BADGE_TEXT_MAX_NUMBER + "+";
        } else {
            badgeStringText = String.valueOf(badgeText);
        }

        return badgeStringText;
    }
}
