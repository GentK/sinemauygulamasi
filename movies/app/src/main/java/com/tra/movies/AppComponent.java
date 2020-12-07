package com.tra.movies;

import com.tra.movies.details.DetailsComponent;
import com.tra.movies.details.DetailsModule;
import com.tra.movies.favorites.FavoritesModule;
import com.tra.movies.listing.ListingComponent;
import com.tra.movies.listing.ListingModule;
import com.tra.movies.network.NetworkModule;

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
