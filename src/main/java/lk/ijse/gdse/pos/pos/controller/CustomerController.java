package lk.ijse.gdse.pos.pos.controller;

import jakarta.json.JsonArrayBuilder;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.BoFactory;
import lk.ijse.gdse.pos.pos.bo.CustomerBo;
import lk.ijse.gdse.pos.pos.bo.CustomerBoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.util.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/customer", loadOnStartup = 2)
public class CustomerController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    Connection connection;
    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER);

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.connection = new DbConnection().getDbConnection();
        logger.info("Customer Servlet Init Method Invoked!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method Invoked");

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }else {
            try(var writer = resp.getWriter()){
                Jsonb jsonb = JsonbBuilder.create();
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
               if (customerBo.saveCustomer(customerDto, connection)){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                }else{
                   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
               }
            }catch (Exception e){
                logger.error("Something went wrong in customer post method!");
            }
        }
    }

    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try(var writer = resp.getWriter()){
//            Jsonb jsonb = JsonbBuilder.create();
//            var customerId = req.getParameter("id");
//            resp.setContentType("application/json");
//            jsonb.toJson(customerBo.getCustomer(customerId, connection), writer);
//        }catch (Exception e){
//
//        }
//    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var type = req.getParameter("type");
        if (type.equals("one")){
            try(var writer = resp.getWriter()){
                Jsonb jsonb = JsonbBuilder.create();
                var customerId = req.getParameter("id");
                resp.setContentType("application/json");
                jsonb.toJson(customerBo.getCustomer(customerId, connection), writer);
            }catch (Exception e){
                logger.error("Something went wrong in customer doGet() method : " + e.getMessage());
            }
        }else {
            try(var writer = resp.getWriter()){
                List<CustomerDto> allCustomers = customerBo.getAllCustomers(connection);
                var jsonb = JsonbBuilder.create();
                resp.setContentType("application/json");
                jsonb.toJson(allCustomers, writer);
            }catch (Exception e){
                logger.error("Something went wrong in customer doGet() method : " + e.getMessage());
            }
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            var customerId = req.getParameter("id");
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
            if (customerBo.updateCustomer(customerId, customerDto, connection)){
                resp.setStatus(HttpServletResponse.SC_CREATED);
//                writer.write("Customer Update Successfully!");
            }else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            logger.error("Something went wrong in customer doPut() method : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            var customerId = req.getParameter("id");
            if (customerBo.deleteCustomer(customerId, connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                writer.write("Customer Deleted Successfully!");
            }else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
