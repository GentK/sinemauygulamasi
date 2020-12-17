package com.gent.movies;

import com.gent.movies.details.DetailsComponent;
import com.gent.movies.details.DetailsModule;
import com.gent.movies.favorites.FavoritesModule;
import com.gent.movies.listing.ListingComponent;
import com.gent.movies.listing.ListingModule;
import com.gent.movies.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author arunsasidharan
 * @author pulkitkumar
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
