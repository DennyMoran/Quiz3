import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Modelos.Carrito;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Server {
	static ArrayList<Carrito> carrito = new ArrayList<>();
	static Logger log = LoggerFactory.getLogger(Server.class);
	
    public static void main(String[] args) {
    	port(3030);
    	staticFiles.location("/staticFiles");
		before((req, res) -> {
			if (Carrito.size() == 0) {
				carrito.add(new Carrito(
						"Precio: 10",
						"Articulo: USB",
						"Descripcion: 32GB",
						"Cantidad: 1"
				));
				carrito.add(new Carrito(
					"Price: 10",
					"Article: Gorra",
					"Descripcion: comoda",
					"Cantidad: 2"
				));
			}
		});
		
		
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("carrito", carrito);
			return new ModelAndView(model, "home.ftl");
		}, new FreeMarkerEngine());
	}

}
