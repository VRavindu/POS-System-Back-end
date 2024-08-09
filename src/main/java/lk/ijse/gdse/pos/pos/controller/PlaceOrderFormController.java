package lk.ijse.gdse.pos.pos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.*;
import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.dto.OrderDto;
import lk.ijse.gdse.pos.pos.util.DbConnection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/placeorder")
public class PlaceOrderFormController extends HttpServlet {
    Connection connection;
    OrderBo orderBo = (OrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.ORDER);
    OrderDetailBo orderDetailBo = (OrderDetailBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.ORDER_DETAIL);

    public void init() throws ServletException {
        System.out.println("Place Order Init method Invoked");
        this.connection = new DbConnection().getDbConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("order")) {

            try {
                if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    try (var writer = resp.getWriter()) {
                        Jsonb jsonb = JsonbBuilder.create();
                        OrderDto orderDto = jsonb.fromJson(req.getReader(), OrderDto.class);
                        System.out.println("order ek");
                        writer.write(orderBo.saveOrder(orderDto, connection));
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                } else {
                    try (var writer = resp.getWriter()) {
//                        Jsonb jsonb = JsonbBuilder.create();
//                        OrderDetailDto orderDetailDto = jsonb.fromJson(req.getReader(), OrderDetailDto.class);
//                        writer.write(orderDetailBo.saveOrderDetail(orderDetailDto, connection));
//                    }catch (Exception e){
//
//                    }

//                        Jsonb jsonb = JsonbBuilder.create();
//
//                        // Read the JSON array from the request body
//                        var reader = req.getReader();
//                        List<OrderDetailDto> orderDetailDtoList = jsonb.fromJson(reader, new javax.json.reflect.TypeLiteral<List<OrderDetailDto>>() {
//                        }.getType());
//
//                        // Iterate over the list and save each order detail
//                        for (OrderDetailDto orderDetailDto : orderDetailDtoList) {
//                            // Assuming orderDetailBo.saveOrderDetail returns a string representation of the result
//                            writer.write(orderDetailBo.saveOrderDetail(orderDetailDto, connection));
//                        }


                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }catch (Exception e){

            }
        }
    }
}





