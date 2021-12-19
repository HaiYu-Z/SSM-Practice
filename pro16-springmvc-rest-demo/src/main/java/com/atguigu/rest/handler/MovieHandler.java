package com.atguigu.rest.handler;

import com.atguigu.rest.entity.Movie;
import com.atguigu.rest.service.api.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 17:12
 */
@Controller
public class MovieHandler {
    @Autowired
    private MovieService movieService;
    
    @RequestMapping(value = "/movie/list", method = RequestMethod.GET)
    public String empList(Model model) {
        List<Movie> movieList = movieService.getAll();
        model.addAttribute("movieList", movieList);
        return "movie-list";
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable("movieId") String movieId) {
        System.out.println(movieId);
        movieService.removeMovieById(movieId);
        return "redirect:/movie/list";
    }

    @RequestMapping(value = "/movie",method = RequestMethod.POST)
    public String addMovie(Movie movie, Model model) {
        boolean movieNameExist = movieService.isMovieNameExist(movie.getMovieName());
        if (movieNameExist) {
            model.addAttribute("msg","电影已存在！");
            return "movie-add";
        }
        movieService.saveMovie(movie);
        return "redirect:/movie/list";
    }

    @RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
    public String updateMoviePage(@PathVariable("movieId") String movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "movie-update";
    }

    @RequestMapping(value = "/movie",method = RequestMethod.PUT)
    public String updateMovie(Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/movie/list";
    }
}
