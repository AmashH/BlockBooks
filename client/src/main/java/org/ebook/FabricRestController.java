// src/main/java/org/ebook/FabricRestController.java
package org.ebook;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FabricRestController {

    private final FabricClient fabricClient;

    public FabricRestController() {
        this.fabricClient = new FabricClient();
    }

    @PostMapping("/licenses")
    public Map<String, Object> issueLicense(@RequestBody Map<String, String> request) {
        String bookId = request.get("book_id");
        String userId = request.get("user_id");

        Map<String, Object> response = new HashMap<>();

        try {
            // Call FabricClient
            String licenseId = fabricClient.issueLicense(bookId, userId);

            response.put("success", true);
            response.put("license_id", licenseId);
            response.put("timestamp", System.currentTimeMillis());

        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }

        return response;
    }

    @GetMapping("/licenses/{licenseId}")
    public Map<String, Object> queryLicense(@PathVariable String licenseId) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Call FabricClient
            String license = fabricClient.queryLicense(licenseId);

            response.put("success", true);
            response.put("license_id", licenseId);
            response.put("data", license);

        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }

        return response;
    }

    @PutMapping("/licenses/{licenseId}/transfer")
    public Map<String, Object> transferLicense(@PathVariable String licenseId,
            @RequestBody Map<String, String> request) {
        String newOwnerId = request.get("new_owner_id");
        Map<String, Object> response = new HashMap<>();

        try {
            // call FabricClient
            String result = fabricClient.transferLicense(licenseId, newOwnerId);
            response.put("success", true);
            response.put("license_id", licenseId);
            response.put("new_owner_id", newOwnerId);
            response.put("timestamp", System.currentTimeMillis());

        } catch (Exception e) {
            response.put("success", false);
            response.put("error, ", e.getMessage());
        }
        return response;

    }
}