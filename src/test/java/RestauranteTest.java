
import ar.edu.unrn.tp1.segundo.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestauranteTest {

    @Test
    public void numeroMesaValido() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        var exception = assertThrows(IllegalArgumentException.class, () -> new Mesa(-1, comida, bebida));
        assertEquals("El número de mesa no puede ser menor a 1", exception.getMessage());
    }

    @Test
    public void precioProductoValido() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new ItemMenu("Item", -1f, "Descripción"));
        assertEquals("El precio no puede ser menor o igual a cero", exception.getMessage());
    }

    @Test
    public void nombreProductoValido() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new ItemMenu("", 1f, "Descripción"));
        assertEquals("El nombre no puede estar vacío", exception.getMessage());
    }

    @Test
    public void descripcionProductoValido() {
        var exception = assertThrows(IllegalArgumentException.class, () -> new ItemMenu("Item", 1f, ""));
        assertEquals("La descripción no puede estar vacía", exception.getMessage());
    }

    @Test
    public void precioFinalValido() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        comida.add(new ItemMenu("Pizza", 100f, "Pizza de muzzarella"));
        bebida.add(new ItemMenu("Cerveza", 50f, "Cerveza rubia"));

        Mesa mesa = new Mesa(1, comida, bebida);

        float precioFinalSinDescuento = mesa.precioTotalSinDescuento();

        assertEquals(150f, precioFinalSinDescuento);
    }

    @Test
    public void precioFinalVisa() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        comida.add(new ItemMenu("Pizza", 100f, "Pizza de muzzarella"));
        bebida.add(new ItemMenu("Cerveza", 50f, "Cerveza rubia"));

        Mesa mesa = new Mesa(1, comida, bebida);

        var tarjeta = new Visa("Visa", 1234567890123456L, LocalDateTime.now().plusYears(1), 123);
        float precioFinal = mesa.precioFinal(tarjeta, Propina.BAJO);
        assertEquals(151.47000122070312f, precioFinal); //no sé como redondear el precioFinal
    }

    @Test
    public void precioFinalMasterCard() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        comida.add(new ItemMenu("Pizza", 100f, "Pizza de muzzarella"));
        bebida.add(new ItemMenu("Cerveza", 50f, "Cerveza rubia"));

        Mesa mesa = new Mesa(1, comida, bebida);

        var tarjeta = new Mastercard("MasterCard", 1234567890123456L, LocalDateTime.now().plusYears(1), 123);
        float precioFinal = mesa.precioFinal(tarjeta, Propina.BAJO);
        assertEquals(150.96f, precioFinal); //no sé como redondear el precioFinal
    }

    @Test
    public void precioFinalComarcaPlus() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        comida.add(new ItemMenu("Pizza", 100f, "Pizza de muzzarella"));
        bebida.add(new ItemMenu("Cerveza", 50f, "Cerveza rubia"));

        Mesa mesa = new Mesa(1, comida, bebida);

        var tarjeta = new ComarcaPlus("Comarca Plus", 1234567890123456L, LocalDateTime.now().plusYears(1), 123);
        float precioFinal = mesa.precioFinal(tarjeta, Propina.BAJO);
        assertEquals(149.94f, precioFinal); //no sé como redondear el precioFinal
    }

    @Test
    public void precioViedma() {
        ArrayList<ItemMenu> bebida = new ArrayList<>();
        ArrayList<ItemMenu> comida = new ArrayList<>();
        comida.add(new ItemMenu("Pizza", 100f, "Pizza de muzzarella"));
        bebida.add(new ItemMenu("Cerveza", 50f, "Cerveza rubia"));

        Mesa mesa = new Mesa(1, comida, bebida);

        var tarjeta = new Viedma("Viedma", 1234567890123456L, LocalDateTime.now().plusYears(1), 123);
        float precioFinal = mesa.precioFinal(tarjeta, Propina.BAJO);
        assertEquals(153f, precioFinal);
    }


}
