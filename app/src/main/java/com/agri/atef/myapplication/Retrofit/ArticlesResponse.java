package com.agri.atef.myapplication.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class A1Response {
    @SerializedName("ArticleId")
    @Expose
    private Integer articleId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("information")
    @Expose
    private String information;

    @SerializedName("imge")
    @Expose
    private String imge;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getImge() {
        return imge;
    }

    public void setImge(String imge) {
        this.imge = imge;
    }
}
