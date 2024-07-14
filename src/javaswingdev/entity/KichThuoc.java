
package javaswingdev.entity;


public class KichThuoc {
    private Long idSize;
    private String maSize;
    private float tenSize;
    private String nguoiTao;
    private int trangThai;

    public KichThuoc() {
    }

    public KichThuoc(Long idSize, String maSize, float tenSize, String nguoiTao, int trangThai) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
    }
    
    public KichThuoc(float tenSize) {
        this.tenSize = tenSize;
    }

    public KichThuoc(Long idSize) {
        this.idSize = idSize;
    }

    public KichThuoc(Long idSize, float tenSize) {
        this.idSize = idSize;
        this.tenSize = tenSize;
    }

    public KichThuoc(Long idSize, String maSize, float tenSize) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public KichThuoc(Long idSize, String maSize, float tenSize, int trangThai) {
        this.idSize = idSize;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
    }

    public KichThuoc(String maSize, float tenSize, int trangThai) {
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.trangThai = trangThai;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }
    
    public Long getIdSize() {
        return idSize;
    }

    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public float getTenSize() {
        return tenSize;
    }

    public void setTenSize(float tenSize) {
        this.tenSize = tenSize;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return  tenSize +"";
    }

}
