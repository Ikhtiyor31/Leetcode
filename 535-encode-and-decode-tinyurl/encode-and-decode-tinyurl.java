public class Codec {

    // Encodes a URL to a shortened URL.
    Map<String, String> cache = new HashMap<>();
    private int id = 0;
    public String encode(String longUrl) {
        String newUrl = "https://tiny.url" + id;
        id += 1;
        cache.put(newUrl, longUrl);
        return newUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
       return cache.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));