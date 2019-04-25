package com.lambdaschool.coffeebean.CriteriaAPIProducts;

public class ProductWithReview
{
    Long productid;
    String productname;
    String description;
    String image;
    Double price;

    Double AvgRating;
    Long ReviewCount;

    public ProductWithReview(Long productid, String productname, String description, String image, Double price, Double AvgRating, Long ReviewCount)
    {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.image = image;
        this.price = price;
        this.AvgRating = AvgRating;
        this.ReviewCount = ReviewCount;
    }

    public ProductWithReview()
    {
    }

    public Long getProductid()
    {
        return productid;
    }

    public void setProductid(Long productid)
    {
        this.productid = productid;
    }

    public String getProductname()
    {
        return productname;
    }

    public void setProductname(String productname)
    {
        this.productname = productname;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getAvgRating()
    {
        return AvgRating;
    }

    public void setAvgRating(Double avgRating)
    {
        AvgRating = avgRating;
    }

    public Long getReviewCount()
    {
        return ReviewCount;
    }

    public void setReviewCount(Long reviewCount)
    {
        ReviewCount = reviewCount;
    }
}
