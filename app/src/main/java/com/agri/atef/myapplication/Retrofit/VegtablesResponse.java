
package com.agri.atef.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VegtablesResponse {
    if (response.body().isValue()) {
        bankAccountAdapter.addAll(response.body().getData().getBankAccounts());
        rvBankAccount.setAdapter(bankAccountAdapter);

    @SerializedName("Vid")
    @Expose
    private Integer vid;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("soild")
    @Expose
    private String soild;
    @SerializedName("info")
    @Expose
    private String info;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoild() {
        return soild;
    }

    public void setSoild(String soild) {
        this.soild = soild;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
