package com.example.instantparty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "reviews"
})
class AllReviews {

    @JsonProperty("reviews")
    private List<Review> reviews = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("reviews")
    public List<Review> getReviews() {
        return reviews;
    }

    @JsonProperty("reviews")
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "tint"
})
class BgColor {

    @JsonProperty("type")
    private String type;
    @JsonProperty("tint")
    private String tint;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("tint")
    public String getTint() {
        return tint;
    }

    @JsonProperty("tint")
    public void setTint(String tint) {
        this.tint = tint;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "delivery",
        "takeaway"
})
class HasMenuStatus {

    @JsonProperty("delivery")
    private int delivery;
    @JsonProperty("takeaway")
    private int takeaway;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("delivery")
    public int getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("takeaway")
    public int getTakeaway() {
        return takeaway;
    }

    @JsonProperty("takeaway")
    public void setTakeaway(int takeaway) {
        this.takeaway = takeaway;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address",
        "locality",
        "city",
        "city_id",
        "latitude",
        "longitude",
        "zipcode",
        "country_id",
        "locality_verbose"
})
class Location {

    @JsonProperty("address")
    private String address;
    @JsonProperty("locality")
    private String locality;
    @JsonProperty("city")
    private String city;
    @JsonProperty("city_id")
    private int cityId;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("country_id")
    private int countryId;
    @JsonProperty("locality_verbose")
    private String localityVerbose;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    @JsonProperty("locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("city_id")
    public int getCityId() {
        return cityId;
    }

    @JsonProperty("city_id")
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("zipcode")
    public String getZipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonProperty("country_id")
    public int getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("locality_verbose")
    public String getLocalityVerbose() {
        return localityVerbose;
    }

    @JsonProperty("locality_verbose")
    public void setLocalityVerbose(String localityVerbose) {
        this.localityVerbose = localityVerbose;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "photo"
})
class Photo {

    @JsonProperty("photo")
    private Photo_ photo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("photo")
    public Photo_ getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Photo_ photo) {
        this.photo = photo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "url",
        "thumb_url",
        "user",
        "res_id",
        "caption",
        "timestamp",
        "friendly_time",
        "width",
        "height"
})
class Photo_ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumb_url")
    private String thumbUrl;
    @JsonProperty("user")
    private User user;
    @JsonProperty("res_id")
    private int resId;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("timestamp")
    private int timestamp;
    @JsonProperty("friendly_time")
    private String friendlyTime;
    @JsonProperty("width")
    private int width;
    @JsonProperty("height")
    private int height;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("thumb_url")
    public String getThumbUrl() {
        return thumbUrl;
    }

    @JsonProperty("thumb_url")
    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("res_id")
    public int getResId() {
        return resId;
    }

    @JsonProperty("res_id")
    public void setResId(int resId) {
        this.resId = resId;
    }

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonProperty("timestamp")
    public int getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("friendly_time")
    public String getFriendlyTime() {
        return friendlyTime;
    }

    @JsonProperty("friendly_time")
    public void setFriendlyTime(String friendlyTime) {
        this.friendlyTime = friendlyTime;
    }

    @JsonProperty("width")
    public int getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(int width) {
        this.width = width;
    }

    @JsonProperty("height")
    public int getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(int height) {
        this.height = height;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "has_menu_status",
        "res_id"
})
class R1 {

    @JsonProperty("has_menu_status")
    private HasMenuStatus hasMenuStatus;
    @JsonProperty("res_id")
    private int resId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("has_menu_status")
    public HasMenuStatus getHasMenuStatus() {
        return hasMenuStatus;
    }

    @JsonProperty("has_menu_status")
    public void setHasMenuStatus(HasMenuStatus hasMenuStatus) {
        this.hasMenuStatus = hasMenuStatus;
    }

    @JsonProperty("res_id")
    public int getResId() {
        return resId;
    }

    @JsonProperty("res_id")
    public void setResId(int resId) {
        this.resId = resId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "title",
        "bg_color"
})
class RatingObj {

    @JsonProperty("title")
    private Title title;
    @JsonProperty("bg_color")
    private BgColor bgColor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(Title title) {
        this.title = title;
    }

    @JsonProperty("bg_color")
    public BgColor getBgColor() {
        return bgColor;
    }

    @JsonProperty("bg_color")
    public void setBgColor(BgColor bgColor) {
        this.bgColor = bgColor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "restaurant"
})
class Restaurant {

    @JsonProperty("restaurant")
    private Restaurant_ restaurant;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("restaurant")
    public Restaurant_ getRestaurant() {
        return restaurant;
    }

    @JsonProperty("restaurant")
    public void setRestaurant(Restaurant_ restaurant) {
        this.restaurant = restaurant;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "R",
        "apikey",
        "id",
        "name",
        "url",
        "location",
        "switch_to_order_menu",
        "cuisines",
        "timings",
        "average_cost_for_two",
        "price_range",
        "currency",
        "highlights",
        "offers",
        "opentable_support",
        "is_zomato_book_res",
        "mezzo_provider",
        "is_book_form_web_view",
        "book_form_web_view_url",
        "book_again_url",
        "thumb",
        "user_rating",
        "all_reviews_count",
        "photos_url",
        "photo_count",
        "photos",
        "menu_url",
        "featured_image",
        "has_online_delivery",
        "is_delivering_now",
        "store_type",
        "include_bogo_offers",
        "deeplink",
        "is_table_reservation_supported",
        "has_table_booking",
        "events_url",
        "phone_numbers",
        "all_reviews",
        "establishment",
        "establishment_types"
})
class Restaurant_ {

    @JsonProperty("R")
    private R1 r;
    @JsonProperty("apikey")
    private String apikey;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("switch_to_order_menu")
    private int switchToOrderMenu;
    @JsonProperty("cuisines")
    private String cuisines;
    @JsonProperty("timings")
    private String timings;
    @JsonProperty("average_cost_for_two")
    private int averageCostForTwo;
    @JsonProperty("price_range")
    private int priceRange;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("highlights")
    private List<String> highlights = null;
    @JsonProperty("offers")
    private List<Object> offers = null;
    @JsonProperty("opentable_support")
    private int opentableSupport;
    @JsonProperty("is_zomato_book_res")
    private int isZomatoBookRes;
    @JsonProperty("mezzo_provider")
    private String mezzoProvider;
    @JsonProperty("is_book_form_web_view")
    private int isBookFormWebView;
    @JsonProperty("book_form_web_view_url")
    private String bookFormWebViewUrl;
    @JsonProperty("book_again_url")
    private String bookAgainUrl;
    @JsonProperty("thumb")
    private String thumb;
    @JsonProperty("user_rating")
    private UserRating userRating;
    @JsonProperty("all_reviews_count")
    private int allReviewsCount;
    @JsonProperty("photos_url")
    private String photosUrl;
    @JsonProperty("photo_count")
    private int photoCount;
    @JsonProperty("photos")
    private List<Photo> photos = null;
    @JsonProperty("menu_url")
    private String menuUrl;
    @JsonProperty("featured_image")
    private String featuredImage;
    @JsonProperty("has_online_delivery")
    private int hasOnlineDelivery;
    @JsonProperty("is_delivering_now")
    private int isDeliveringNow;
    @JsonProperty("store_type")
    private String storeType;
    @JsonProperty("include_bogo_offers")
    private boolean includeBogoOffers;
    @JsonProperty("deeplink")
    private String deeplink;
    @JsonProperty("is_table_reservation_supported")
    private int isTableReservationSupported;
    @JsonProperty("has_table_booking")
    private int hasTableBooking;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("phone_numbers")
    private String phoneNumbers;
    @JsonProperty("all_reviews")
    private AllReviews allReviews;
    @JsonProperty("establishment")
    private List<String> establishment = null;
    @JsonProperty("establishment_types")
    private List<Object> establishmentTypes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("R")
    public R1 getR() {
        return r;
    }

    @JsonProperty("R")
    public void setR(R1 r) {
        this.r = r;
    }

    @JsonProperty("apikey")
    public String getApikey() {
        return apikey;
    }

    @JsonProperty("apikey")
    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("switch_to_order_menu")
    public int getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    @JsonProperty("switch_to_order_menu")
    public void setSwitchToOrderMenu(int switchToOrderMenu) {
        this.switchToOrderMenu = switchToOrderMenu;
    }

    @JsonProperty("cuisines")
    public String getCuisines() {
        return cuisines;
    }

    @JsonProperty("cuisines")
    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    @JsonProperty("timings")
    public String getTimings() {
        return timings;
    }

    @JsonProperty("timings")
    public void setTimings(String timings) {
        this.timings = timings;
    }

    @JsonProperty("average_cost_for_two")
    public int getAverageCostForTwo() {
        return averageCostForTwo;
    }

    @JsonProperty("average_cost_for_two")
    public void setAverageCostForTwo(int averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    @JsonProperty("price_range")
    public int getPriceRange() {
        return priceRange;
    }

    @JsonProperty("price_range")
    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("highlights")
    public List<String> getHighlights() {
        return highlights;
    }

    @JsonProperty("highlights")
    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    @JsonProperty("offers")
    public List<Object> getOffers() {
        return offers;
    }

    @JsonProperty("offers")
    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    @JsonProperty("opentable_support")
    public int getOpentableSupport() {
        return opentableSupport;
    }

    @JsonProperty("opentable_support")
    public void setOpentableSupport(int opentableSupport) {
        this.opentableSupport = opentableSupport;
    }

    @JsonProperty("is_zomato_book_res")
    public int getIsZomatoBookRes() {
        return isZomatoBookRes;
    }

    @JsonProperty("is_zomato_book_res")
    public void setIsZomatoBookRes(int isZomatoBookRes) {
        this.isZomatoBookRes = isZomatoBookRes;
    }

    @JsonProperty("mezzo_provider")
    public String getMezzoProvider() {
        return mezzoProvider;
    }

    @JsonProperty("mezzo_provider")
    public void setMezzoProvider(String mezzoProvider) {
        this.mezzoProvider = mezzoProvider;
    }

    @JsonProperty("is_book_form_web_view")
    public int getIsBookFormWebView() {
        return isBookFormWebView;
    }

    @JsonProperty("is_book_form_web_view")
    public void setIsBookFormWebView(int isBookFormWebView) {
        this.isBookFormWebView = isBookFormWebView;
    }

    @JsonProperty("book_form_web_view_url")
    public String getBookFormWebViewUrl() {
        return bookFormWebViewUrl;
    }

    @JsonProperty("book_form_web_view_url")
    public void setBookFormWebViewUrl(String bookFormWebViewUrl) {
        this.bookFormWebViewUrl = bookFormWebViewUrl;
    }

    @JsonProperty("book_again_url")
    public String getBookAgainUrl() {
        return bookAgainUrl;
    }

    @JsonProperty("book_again_url")
    public void setBookAgainUrl(String bookAgainUrl) {
        this.bookAgainUrl = bookAgainUrl;
    }

    @JsonProperty("thumb")
    public String getThumb() {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @JsonProperty("user_rating")
    public UserRating getUserRating() {
        return userRating;
    }

    @JsonProperty("user_rating")
    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    @JsonProperty("all_reviews_count")
    public int getAllReviewsCount() {
        return allReviewsCount;
    }

    @JsonProperty("all_reviews_count")
    public void setAllReviewsCount(int allReviewsCount) {
        this.allReviewsCount = allReviewsCount;
    }

    @JsonProperty("photos_url")
    public String getPhotosUrl() {
        return photosUrl;
    }

    @JsonProperty("photos_url")
    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    @JsonProperty("photo_count")
    public int getPhotoCount() {
        return photoCount;
    }

    @JsonProperty("photo_count")
    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    @JsonProperty("photos")
    public List<Photo> getPhotos() {
        return photos;
    }

    @JsonProperty("photos")
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    @JsonProperty("menu_url")
    public String getMenuUrl() {
        return menuUrl;
    }

    @JsonProperty("menu_url")
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @JsonProperty("featured_image")
    public String getFeaturedImage() {
        return featuredImage;
    }

    @JsonProperty("featured_image")
    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    @JsonProperty("has_online_delivery")
    public int getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    @JsonProperty("has_online_delivery")
    public void setHasOnlineDelivery(int hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    @JsonProperty("is_delivering_now")
    public int getIsDeliveringNow() {
        return isDeliveringNow;
    }

    @JsonProperty("is_delivering_now")
    public void setIsDeliveringNow(int isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    @JsonProperty("store_type")
    public String getStoreType() {
        return storeType;
    }

    @JsonProperty("store_type")
    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    @JsonProperty("include_bogo_offers")
    public boolean isIncludeBogoOffers() {
        return includeBogoOffers;
    }

    @JsonProperty("include_bogo_offers")
    public void setIncludeBogoOffers(boolean includeBogoOffers) {
        this.includeBogoOffers = includeBogoOffers;
    }

    @JsonProperty("deeplink")
    public String getDeeplink() {
        return deeplink;
    }

    @JsonProperty("deeplink")
    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    @JsonProperty("is_table_reservation_supported")
    public int getIsTableReservationSupported() {
        return isTableReservationSupported;
    }

    @JsonProperty("is_table_reservation_supported")
    public void setIsTableReservationSupported(int isTableReservationSupported) {
        this.isTableReservationSupported = isTableReservationSupported;
    }

    @JsonProperty("has_table_booking")
    public int getHasTableBooking() {
        return hasTableBooking;
    }

    @JsonProperty("has_table_booking")
    public void setHasTableBooking(int hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    @JsonProperty("phone_numbers")
    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    @JsonProperty("phone_numbers")
    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @JsonProperty("all_reviews")
    public AllReviews getAllReviews() {
        return allReviews;
    }

    @JsonProperty("all_reviews")
    public void setAllReviews(AllReviews allReviews) {
        this.allReviews = allReviews;
    }

    @JsonProperty("establishment")
    public List<String> getEstablishment() {
        return establishment;
    }

    @JsonProperty("establishment")
    public void setEstablishment(List<String> establishment) {
        this.establishment = establishment;
    }

    @JsonProperty("establishment_types")
    public List<Object> getEstablishmentTypes() {
        return establishmentTypes;
    }

    @JsonProperty("establishment_types")
    public void setEstablishmentTypes(List<Object> establishmentTypes) {
        this.establishmentTypes = establishmentTypes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "review"
})
class Review {

    @JsonProperty("review")
    private List<Object> review = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("review")
    public List<Object> getReview() {
        return review;
    }

    @JsonProperty("review")
    public void setReview(List<Object> review) {
        this.review = review;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "results_found",
        "results_start",
        "results_shown",
        "restaurants"
})
public class Search {

    @JsonProperty("results_found")
    private int resultsFound;
    @JsonProperty("results_start")
    private int resultsStart;
    @JsonProperty("results_shown")
    private int resultsShown;
    @JsonProperty("restaurants")
    private List<Restaurant> restaurants = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("results_found")
    public int getResultsFound() {
        return resultsFound;
    }

    @JsonProperty("results_found")
    public void setResultsFound(int resultsFound) {
        this.resultsFound = resultsFound;
    }

    @JsonProperty("results_start")
    public int getResultsStart() {
        return resultsStart;
    }

    @JsonProperty("results_start")
    public void setResultsStart(int resultsStart) {
        this.resultsStart = resultsStart;
    }

    @JsonProperty("results_shown")
    public int getResultsShown() {
        return resultsShown;
    }

    @JsonProperty("results_shown")
    public void setResultsShown(int resultsShown) {
        this.resultsShown = resultsShown;
    }

    @JsonProperty("restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @JsonProperty("restaurants")
    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "text"
})
class Title {

    @JsonProperty("text")
    private String text;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "foodie_color",
        "profile_url",
        "profile_image",
        "profile_deeplink"
})
class User {

    @JsonProperty("name")
    private String name;
    @JsonProperty("foodie_color")
    private String foodieColor;
    @JsonProperty("profile_url")
    private String profileUrl;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("profile_deeplink")
    private String profileDeeplink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("foodie_color")
    public String getFoodieColor() {
        return foodieColor;
    }

    @JsonProperty("foodie_color")
    public void setFoodieColor(String foodieColor) {
        this.foodieColor = foodieColor;
    }

    @JsonProperty("profile_url")
    public String getProfileUrl() {
        return profileUrl;
    }

    @JsonProperty("profile_url")
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @JsonProperty("profile_image")
    public String getProfileImage() {
        return profileImage;
    }

    @JsonProperty("profile_image")
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @JsonProperty("profile_deeplink")
    public String getProfileDeeplink() {
        return profileDeeplink;
    }

    @JsonProperty("profile_deeplink")
    public void setProfileDeeplink(String profileDeeplink) {
        this.profileDeeplink = profileDeeplink;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "aggregate_rating",
        "rating_text",
        "rating_color",
        "rating_obj",
        "votes"
})
class UserRating {

    @JsonProperty("aggregate_rating")
    private String aggregateRating;
    @JsonProperty("rating_text")
    private String ratingText;
    @JsonProperty("rating_color")
    private String ratingColor;
    @JsonProperty("rating_obj")
    private RatingObj ratingObj;
    @JsonProperty("votes")
    private String votes;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aggregate_rating")
    public String getAggregateRating() {
        return aggregateRating;
    }

    @JsonProperty("aggregate_rating")
    public void setAggregateRating(String aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    @JsonProperty("rating_text")
    public String getRatingText() {
        return ratingText;
    }

    @JsonProperty("rating_text")
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    @JsonProperty("rating_color")
    public String getRatingColor() {
        return ratingColor;
    }

    @JsonProperty("rating_color")
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    @JsonProperty("rating_obj")
    public RatingObj getRatingObj() {
        return ratingObj;
    }

    @JsonProperty("rating_obj")
    public void setRatingObj(RatingObj ratingObj) {
        this.ratingObj = ratingObj;
    }

    @JsonProperty("votes")
    public String getVotes() {
        return votes;
    }

    @JsonProperty("votes")
    public void setVotes(String votes) {
        this.votes = votes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}