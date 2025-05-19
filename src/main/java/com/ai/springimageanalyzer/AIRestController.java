package com.ai.springimageanalyzer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AIRestController {
    private final AIService aiService;

    public AIRestController(AIService aiService) {
        this.aiService = aiService;
    }


    @PostMapping("/api/screenshot")
    public ResponseEntity<HttpStatus> processScreenshot(
            @RequestParam("file") MultipartFile file,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String businessId,
            @RequestParam(required = false) String domainId,
            @RequestParam(required = false) String project) {
//        ScreenshotLog log = aiService.processScreenshot(file, userId, businessId, domainId, project);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/api/screenshot/stream/{id}")
    public ResponseEntity<HttpStatus> streamProcessedImage(@PathVariable String id) {
        // Implement streaming logic
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/screenshot/reports")
    public ResponseEntity<HttpStatus> getReports(
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String businessId,
            @RequestParam(required = false) String domainId,
            @RequestParam(required = false) String project) {
        // Implement report generation logic
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
