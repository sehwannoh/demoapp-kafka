package demoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO implements Serializable {

    private String id;
    private Long dealerId;
    private String dealerName;
    private String vin;
    private Integer year;
    private String make;
    private String model;
    private String modelCode;
    private String trim;
    private String vehicleStatus; // IN_STOCK, SOLD
    private String vehicleCondition; // NEW, USED
    private String chromeStyleId;
    private String style;
    private String bodyType;
    private String exteriorColor;
    private String interiorColor;
    private String interiorMaterial;
    private String genericExteriorColor;
    private String engine;
    private String engineFuelType;
    private String transmission;
    private String transmissionSpeed;
    private String drivetrain;
    private Integer cityMpg;
    private Integer hwyMpg;
    private Integer mileage;
    private Double listPrice;
    private Double costPrice;
    private Double specialPrice;
    private List<ImageDTO> images = new ArrayList<>();

}
