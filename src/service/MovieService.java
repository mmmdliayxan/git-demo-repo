package service;

import auth.Auth;
import logger.Logger;
import model.Movie;
import model.Role;
import model.User;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Arrays;

public class MovieService {
   private Movie[] movies;
   public MovieService() {
        this.movies = new Movie[0];
    }
    public void addMovie(User currentUser, String name, String description, String duration) throws IOException, AccessDeniedException {
        if (currentUser.getRole() != Role.ADMIN) {
            Logger.log("İcazəsiz əməliyyat (addMovie) -> " + currentUser.getUserName());
            throw new AccessDeniedException("Bu əməliyyatı yalnız ADMIN görə bilər!");
        }
        Movie[] oldMovies = movies;
        Movie[] newMovies = Arrays.copyOf(oldMovies, oldMovies.length + 1);
        newMovies[newMovies.length - 1] = new Movie(name, description, duration);
        movies = newMovies;

        Logger.log("Yeni film əlavə edildi: " + name);
        System.out.println("Film əlavə olundu: " + name);
    }
    public void viewAllMovies(User currentUser) throws IOException, AccessDeniedException {
        if (currentUser.getRole() != Role.ADMIN) {
            Logger.log("İcazəsiz əməliyyat (viewAllMovies) -> " + currentUser.getUserName());
            throw new AccessDeniedException("Bu əməliyyatı yalnız ADMIN görə bilər!");
        }

        System.out.println("Bütün filmlər:");
        for (Movie m : movies) {
            System.out.println(m);
        }
        Logger.log(currentUser.getUserName() + " bütün filmləri görüntülədi");
    }
    public void viewMovie(String name) throws IOException {
        for (Movie m : movies) {
            if (m.getName().equalsIgnoreCase(name)) {
                System.out.println("Film məlumatları:");
                System.out.println(m);
                Logger.log("Film görüntüləndi: " + name);
                return;
            }
        }
        System.out.println("Film tapılmadı!");
    }
    public void removeMovie(User currentUser, String name) throws IOException,AccessDeniedException {
        if (currentUser.getRole() != Role.ADMIN) {
            Logger.log("İcazəsiz əməliyyat (removeMovie) -> " + currentUser.getUserName());
            throw new AccessDeniedException("Bu əməliyyatı yalnız ADMIN yerinə yetirə bilər!");
        }

        boolean found = false;
        Movie[] newMovies = new Movie[movies.length - 1];
        int index = 0;

        for (Movie m : movies) {
            if (m.getName().equalsIgnoreCase(name)) {
                found = true;
                continue;
            }
            if (index < newMovies.length)
                newMovies[index++] = m;
        }

        if (found) {
            movies = Arrays.copyOf(newMovies, index);
            Logger.log("Film silindi: " + name);
            System.out.println("Film silindi: " + name);
        } else {
            System.out.println("Film tapılmadı!");
        }
    }
    public void updateMovie(User currentUser,String name, String description, String duration) throws IOException,AccessDeniedException{
        if (currentUser.getRole() != Role.ADMIN) {
            Logger.log("İcazəsiz əməliyyat (addMovie) -> " + currentUser.getUserName());
            throw new AccessDeniedException("Bu əməliyyatı yalnız ADMIN görə bilər!");
        }
       for (Movie m : movies) {
            if (m.getName().equalsIgnoreCase(name)) {
                m.setName(name);
                m.setDescription(description);
                m.setDuration(duration);
                Logger.log("Film yeniləndi: " + name);
                System.out.println("Film yeniləndi: " + name);
                return;
            }
        }
        System.out.println("Film tapılmadı!");
    }

}
