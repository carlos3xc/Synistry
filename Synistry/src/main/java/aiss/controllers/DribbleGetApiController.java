package aiss.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.dribbble.Project;
import aiss.model.resources.DribbbleResource;

public class DribbleGetApiController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String accessToken = (String) req.getSession().getAttribute("Spotify-token");

		if (accessToken != null && !"".equals(accessToken)) {

			DribbbleResource drResource = new DribbbleResource(accessToken);
			Project project = drResource.getProject("user"); // cambiar y poner un usuario

			/*
			 * if (playlists != null && playlists.getItems() != null &&
			 * playlists.getItems().size() > 0 && playlists.getItems().get(0) != null) {
			 * req.setAttribute("playlists", playlists);
			 * req.getRequestDispatcher("/spotifyPlaylistsListing.jsp").forward(req, resp);
			 * } else { log.
			 * warning("no playlists available for this user, redirecting to create a new one"
			 * ); req.getRequestDispatcher("/spotifyPlaylistNew").forward(req, resp); } }
			 * else { log.
			 * info("Trying to access Spotify without an access token, redirecting to OAuth servlet"
			 * ); req.getRequestDispatcher("/AuthController/Spotify").forward(req, resp); }
			 */
		}

	}

}
