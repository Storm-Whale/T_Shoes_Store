
package javaswingdev.entity;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor @AllArgsConstructor
public class ChatLieu {
    private Long id;
    private String maCL;
    private String tenCL;
    private String nguoiTao;
    private Integer trangThai;
    
     public ChatLieu() {
    }

    public ChatLieu(Long id, String maCL, String tenCL, String nguoiTao, Integer trangThai) {
        this.id = id;
        this.maCL = maCL;
        this.tenCL = tenCL;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
    }

    public ChatLieu(Long id, String maCL, String tenCL) {
        this.id = id;
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public ChatLieu(Long id, String maCL) {
        this.id = id;
        this.maCL = maCL;
    }

    public ChatLieu(String maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaCL() {
        return maCL;
    }

    public void setMaCL(String maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
     @Override
    public String toString() {
        return  tenCL +"";
    }

}
