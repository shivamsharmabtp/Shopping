package com.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RoundRangeData implements Serializable {
    private BigInteger pricingDate;
    private Long zoneid;
    private Long psid;
    private Float roundTo;
    private Float lowerLimit;
    private Float upperLimit;

    /*public RoundRangeData() {

    }

    public RoundRangeData(BigInteger pricingDate, Long zoneid, Long psid, Float roundTo, Float lowerLimit, Float upperLimit) {
        this.pricingDate = pricingDate;
        this.zoneid = zoneid;
        this.psid = psid;
        this.roundTo = roundTo;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }
*/
    public BigInteger getPricingDate() {
        return pricingDate;
    }

    public void setPricingDate(BigInteger pricingDate) {
        this.pricingDate = pricingDate;
    }

    public Long getZoneid() {
        return zoneid;
    }

    public void setZoneid(Long zoneId) {
        this.zoneid = zoneId;
    }

    public Long getPsid() {
        return psid;
    }

    public void setPsid(Long psid) {
        this.psid = psid;
    }

    public Float getRoundTo() {
        return roundTo;
    }

    public void setRoundTo(Float roundTo) {
        this.roundTo = roundTo;
    }

    public Float getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Float lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Float getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Float upperLimit) {
        this.upperLimit = upperLimit;
    }
}