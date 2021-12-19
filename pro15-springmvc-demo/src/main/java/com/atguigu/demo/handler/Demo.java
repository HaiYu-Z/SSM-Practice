package com.atguigu.demo.handler;

import com.atguigu.demo.entity.Movie;
import com.atguigu.demo.service.api.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 
 * @author HaiYu
 * @date 2021/12/19 8:47
 */
@Controller
public class Demo {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/show/list")
    public String showList(Model model) {
        List<Movie> movieList = movieService.getAll();
        model.addAttribute("movieList", movieList);
        return "movie-list";
    }

    @RequestMapping("/remove/movie")
    public String removeMovie(@RequestParam("movieId") String movieId) {
        movieService.removeMovieById(movieId);
        return "redirect:/show/list";
    }

    @RequestMapping("/add/movie")
    public String addMovie(Movie movie, Model model) {
        boolean movieNameExist = movieService.isMovieNameExist(movie.getMovieName());
        if (movieNameExist) {
            model.addAttribute("msg", "电影已存在！");
            // return "forward:/add-movie.html";
            return "add-movie";
        }
        movieService.saveMovie(movie);
        return "redirect:/show/list";
    }

    @RequestMapping("/update-movie.html")
    public String updateMovieHtml(@RequestParam("movieId") String movieId ,Model model) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie", movie);
        return "update-movie";
    }

    @RequestMapping("/update/movie")
    public String updateMovie(Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/show/list";
    }
}
