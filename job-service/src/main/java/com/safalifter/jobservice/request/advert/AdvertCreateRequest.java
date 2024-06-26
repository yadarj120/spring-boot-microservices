package com.safalifter.jobservice.request.advert;

import com.safalifter.jobservice.enums.Advertiser;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



@Data
public class AdvertCreateRequest {
    @NotBlank(message = "Advert name is required")
    private String name;
    private String description;
    @NotNull(message = "Delivery time is required")
    private int deliveryTime;
    @NotNull(message = "Price is required")
    private int price;
    @NotBlank(message = "Advertiser is required")
    private Advertiser advertiser;
    @NotBlank(message = "User id is required")
    private String userId;
    @NotBlank(message = "Job id is required")
    private String jobId;
}
