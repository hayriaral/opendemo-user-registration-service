package com.hayriaral.opendemo.opendemouserregistrationservice.util;

/**
 * Utility class for regex patterns.
 */
public final class RegexPatterns {

    /**
     * Utility classes should not have public constructor.
     * <p>
     * Utility classes, which are collections of static members, are not meant to be instantiated. Even abstract
     * utility classes, which can be extended, should not have public constructors.
     * <p>
     * Java adds an implicit public constructor to every class which does not define at least one explicitly.
     * Hence, at least one non-public constructor should be defined.
     */
    private RegexPatterns() {
        throw new IllegalStateException(RegexPatterns.class.getName());
    }

    /**
     * This regular expression uses a combination of letters, numbers, and special characters to match the local-part
     * and domain of the email address. The local-part is the part of the email address that comes before the @ symbol,
     * and the domain is the part after the @ symbol.
     * <p>
     * The regular expression is anchored at the start and end with the ^ and $ characters, respectively, to ensure
     * that the entire email address is matched. It uses character classes to match the local-part and domain,
     * as well as several special characters to validate the format of the email address.
     * <p></p>
     * Breakdown of the regular expression:
     * <ul>
     *     <li>^ &ENSP;-> Anchors the regular expression at the start of the string</li>
     *     <li>[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-] &ENSP;-> Matches any combination of letters, numbers, and special
     *     characters in the local-part of the email address</li>
     *     <li>+ &ENSP;-> Requires the previous character class to match at least one character</li>
     *     <li>@ &ENSP;-> Matches the @ symbol</li>
     *     <li>[a-zA-Z0-9] &ENSP;-> Matches any combination of letters and numbers in the domain of the email address</li>
     *     <li>(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])? &ENSP;-> Matches the subdomain of the email address, if present.
     *     The subdomain can be up to 61 characters long and can contain letters, numbers, and hyphens</li>
     *     <li>(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)* &ENSP;-> Matches the domain of the email address.
     *     The domain can consist of multiple subdomains, each of which can be up to 61 characters long and can contain
     *     letters, numbers, and hyphens</li>
     *     <li>\. &ENSP;-> Matches a dot</li>
     *     <li>(?:com|org|net|edu|gov|mil|int|biz|info|pro|name|museum|coop|aero|[a-zA-Z]{2}) &ENSP;-> Matches a common top-level domain</li>
     *     <li>$ &ENSP;-> Anchors the regular expression at the end of the string</li>
     * </ul>
     * <p>
     * Consider using below pattern if you don't mind check allowed Top Level Domains:
     * <p>
     * ^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\.[a-zA-Z]{1,}$
     */
    public static final String EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\\.(?:com|org|net|edu|gov|mil|int|biz|info|pro|name|museum|coop|aero|[a-zA-Z]{2})$";

    /**
     * E.164 is a standard for formatting phone numbers that includes a country code prefixed by a plus sign
     * (e.g., +1 for the United States), followed by the local phone number.
     * The country code can be 1-3 digits in length, and the local phone number can be up to a maximum of 14 digits
     * in length.
     */
    public static final String PHONE_NUMBER_E164 = "^\\+[1-9]\\d{1,14}$";
}
