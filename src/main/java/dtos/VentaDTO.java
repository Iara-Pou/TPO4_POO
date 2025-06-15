package dtos;

import models.Combo;
import models.Venta;

import java.util.Date;
import java.util.List;

public class VentaDTO {
    private int ventaID;
    private Date fchVenta;
    private List<Combo> combos;
    public VentaDTO(FuncionDTO funcion) {

    }
    public VentaDTO(Venta venta) {
        this.ventaID = venta.getVentaID();
        this.fchVenta = venta.getFchVenta();
        this.combos = venta.getCombos();
    }

    public int getVentaID() {
        return ventaID;
    }

    public Date getFchVenta() {
        return fchVenta;
    }

    public List<Combo> getCombos() {
        return combos;
    }
}
