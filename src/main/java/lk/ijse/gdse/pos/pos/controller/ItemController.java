package lk.ijse.gdse.pos.pos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.BoFactory;
import lk.ijse.gdse.pos.pos.bo.ItemBo;
import lk.ijse.gdse.pos.pos.bo.ItemBoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.dto.ItemDto;
import lk.ijse.gdse.pos.pos.util.DbConnection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet {

    Connection connection;

    ItemBo itemBo = (ItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.ITEM);

    @Override
    public void init() throws ServletException {
        this.connection = new DbConnection().getDbConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }else {
                try(var writer = resp.getWriter()){
                    Jsonb jsonb = JsonbBuilder.create();
                    ItemDto itemDto = jsonb.fromJson(req.getReader(), ItemDto.class);
                    writer.write(itemBo.saveItem(itemDto, connection));
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("all")){
            try(var writer = resp.getWriter()){
                List<ItemDto> allItems = itemBo.getAllItems(connection);
                var jsonb = JsonbBuilder.create();
                resp.setContentType("application/json");
                jsonb.toJson(allItems, writer);
            }catch (Exception e){

            }
        }else {
            try(var writer = resp.getWriter()){
                var itemCode = req.getParameter("itemCode");
                Jsonb jsonb = JsonbBuilder.create();
                resp.setContentType("application/json");
                jsonb.toJson(itemBo.getItem(itemCode, connection), writer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Backend eke update eka..");
        try(var writer = resp.getWriter()){
            var itemCode = req.getParameter("itemCode");
            Jsonb jsonb = JsonbBuilder.create();
            ItemDto itemDto = jsonb.fromJson(req.getReader(), ItemDto.class);
            if (itemBo.updateItem(itemCode, itemDto, connection)){
                writer.write("Item Update Successfully!");
            }else {
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            var itemCode = req.getParameter("itemCode");
            if (itemBo.deleteItem(itemCode, connection)){
//                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                writer.write("Item Deleted Successfully!");
            }else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
