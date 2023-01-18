package tech.tresearchgroup.babygalago.view.endpoints.ui;

import io.activej.http.HttpMethod;
import io.activej.http.HttpRequest;
import io.activej.http.HttpResponse;
import io.activej.http.RoutingServlet;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.AbstractModule;
import io.activej.promise.Promisable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import tech.tresearchgroup.babygalago.controller.SettingsController;
import tech.tresearchgroup.babygalago.controller.endpoints.ui.MainEndpointsController;
import tech.tresearchgroup.colobus.controller.IndexController;
import tech.tresearchgroup.palila.model.enums.CompressionMethodEnum;
import tech.tresearchgroup.palila.model.enums.DatabaseTypeEnum;
import tech.tresearchgroup.palila.model.enums.SearchMethodEnum;
import tech.tresearchgroup.schemas.galago.enums.*;

import java.util.Objects;

@AllArgsConstructor
public class MainEndpoints extends AbstractModule {
    private final MainEndpointsController mainEndpointsController;
    private final IndexController indexController;
    private final SettingsController settingsController;

    @Provides
    public RoutingServlet servlet() {
        return RoutingServlet.create()
            .map(HttpMethod.GET, "/about", this::about)
            .map(HttpMethod.GET, "/", this::index)
            .map(HttpMethod.GET, "/login", this::login)
            .map(HttpMethod.GET, "/reset", this::reset)
            .map(HttpMethod.GET, "/register", this::register)
            .map(HttpMethod.POST, "/register", this::postRegister)
            .map(HttpMethod.GET, "/licenses", this::licenses)
            .map(HttpMethod.GET, "/forum/index", this::forum)
            .map(HttpMethod.GET, "/news", this::news)
            .map(HttpMethod.GET, "/notifications", this::notifications)
            .map(HttpMethod.GET, "/profile", this::profile)
            .map(HttpMethod.POST, "/profile", this::postProfile)
            .map(HttpMethod.GET, "/queue", this::queue)
            .map(HttpMethod.POST, "/search", this::search)
            .map(HttpMethod.GET, "/settings", this::settings)
            .map(HttpMethod.POST, "/settings", this::saveSettings)
            .map(HttpMethod.GET, "/upload", this::upload)
            .map(HttpMethod.POST, "/upload", this::postUpload)
            .map(HttpMethod.GET, "/denied", this::denied);
    }

    private @NotNull Promisable<HttpResponse> about(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.about(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> index(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.index(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> login(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.login(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> reset(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.reset(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> register(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.register(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postRegister(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.postRegister(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> licenses(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.licenses(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> forum(@NotNull HttpRequest httpRequest) {
        try {
            return indexController.index(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> news(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.news(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> notifications(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.notifications(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> profile(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.profile(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postProfile(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.postProfile(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> queue(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.queue(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> search(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.search(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> settings(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.settings(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> saveSettings(@NotNull HttpRequest httpRequest) {
        try {
            InterfaceMethodEnum interfaceNetworkUsage = InterfaceMethodEnum.valueOf(httpRequest.getPostParameter("interfaceNetworkUsage"));
            PlaybackQualityEnum defaultPlaybackQuality = PlaybackQualityEnum.valueOf(httpRequest.getPostParameter("defaultPlaybackQuality"));
            boolean debugEnabled = Objects.equals(httpRequest.getPostParameter("debugEnabled"), "on");
            boolean maintenanceMode = Objects.equals(httpRequest.getPostParameter("maintenanceMode"), "on");
            boolean securityEnabled = Objects.equals(httpRequest.getPostParameter("securityEnabled"), "on");
            CompressionMethodEnum compressionMethod = CompressionMethodEnum.valueOf(httpRequest.getPostParameter("compressionMethod"));
            int compressionQuality = Integer.parseInt(httpRequest.getPostParameter("compressionQuality"));
            String securityIssuer = httpRequest.getPostParameter("securityIssuer");
            String securitySecretKey = httpRequest.getPostParameter("securitySecretKey");
            String searchHost = httpRequest.getPostParameter("searchHost");
            String searchKey = httpRequest.getPostParameter("searchKey");
            DisplayModeEnum displayMode = DisplayModeEnum.valueOf(httpRequest.getPostParameter("displayMode"));
            EncoderProgramEnum encoderProgram = EncoderProgramEnum.valueOf(httpRequest.getPostParameter("encoderProgram"));
            InspectorProgramEnum inspectorProgram = InspectorProgramEnum.valueOf(httpRequest.getPostParameter("inspectorProgram"));
            AudioCodecEnum audioCodec = AudioCodecEnum.valueOf(httpRequest.getPostParameter("audioCodec"));
            AudioRateEnum audioRate = AudioRateEnum.valueOf(httpRequest.getPostParameter("audioRate"));
            EncoderPresetEnum audioPreset = EncoderPresetEnum.valueOf(httpRequest.getPostParameter("audioPreset"));
            VideoContainerEnum videoContainer = VideoContainerEnum.valueOf(httpRequest.getPostParameter("videoContainer"));
            VideoCodecEnum videoCodec = VideoCodecEnum.valueOf(httpRequest.getPostParameter("videoCodec"));
            EncoderPresetEnum videoPreset = EncoderPresetEnum.valueOf(httpRequest.getPostParameter("videoPreset"));
            boolean tuneFilm = Objects.equals(httpRequest.getPostParameter("tuneFilm"), "on");
            boolean tuneAnimation = Objects.equals(httpRequest.getPostParameter("tuneAnimation"), "on");
            boolean tuneGrain = Objects.equals(httpRequest.getPostParameter("tuneGrain"), "on");
            boolean stillImage = Objects.equals(httpRequest.getPostParameter("stillImage"), "on");
            boolean fastDecode = Objects.equals(httpRequest.getPostParameter("fastDecode"), "on");
            boolean zeroLatency = Objects.equals(httpRequest.getPostParameter("zeroLatency"), "on");
            boolean fastStart = Objects.equals(httpRequest.getPostParameter("fastStart"), "on");
            boolean tunePsnr = Objects.equals(httpRequest.getPostParameter("tunePsnr"), "on");
            boolean tuneSsnr = Objects.equals(httpRequest.getPostParameter("tuneSsnr"), "on");
            int videoCrf = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("videoCrf")));
            boolean blackBorderRemoval = Objects.equals(httpRequest.getPostParameter("blackBorderRemoval"), "on");
            boolean cudaAcceleration = Objects.equals(httpRequest.getPostParameter("cudaAcceleration"), "on");
            int oneFourFourPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("oneFourFourPTranscodeBitrate")));
            int twoFourZeroPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("twoFourZeroPTranscodeBitrate")));
            int threeSixZeroPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("threeSixZeroPTranscodeBitrate")));
            int fourEightZeroPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("fourEightZeroPTranscodeBitrate")));
            int sevenTwoZeroPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("sevenTwoZeroPTranscodeBitrate")));
            int oneZeroEightZeroPTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("oneZeroEightZeroPTranscodeBitrate")));
            int twoKTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("twoKTranscodeBitrate")));
            int fourKTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("fourKTranscodeBitrate")));
            int eightKTranscodeBitrate = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("eightKTranscodeBitrate")));
            boolean showPoster = Objects.equals(httpRequest.getPostParameter("showPoster"), "on");
            boolean showName = Objects.equals(httpRequest.getPostParameter("showName"), "on");
            boolean showRuntime = Objects.equals(httpRequest.getPostParameter("showRuntime"), "on");
            boolean showGenre = Objects.equals(httpRequest.getPostParameter("showGenre"), "on");
            boolean showMpaaRating = Objects.equals(httpRequest.getPostParameter("showMpaaRating"), "on");
            boolean showUserRating = Objects.equals(httpRequest.getPostParameter("showUserRating"), "on");
            boolean showLanguage = Objects.equals(httpRequest.getPostParameter("showLanguage"), "on");
            boolean showReleaseDate = Objects.equals(httpRequest.getPostParameter("showReleaseDate"), "on");
            boolean showActions = Objects.equals(httpRequest.getPostParameter("showActions"), "on");
            boolean bookLibraryEnable = Objects.equals(httpRequest.getPostParameter("bookLibraryEnable"), "on");
            String bookLibraryPath = httpRequest.getPostParameter("bookLibraryPath");
            boolean bookScanEnable = Objects.equals(httpRequest.getPostParameter("bookScanEnable"), "on");
            int bookScanFrequencyTime = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("bookScanFrequencyTime")));
            ScanFrequencyEnum bookScanFrequencyType = ScanFrequencyEnum.valueOf(httpRequest.getPostParameter("bookScanFrequencyType"));
            boolean gameLibraryEnable = Objects.equals(httpRequest.getPostParameter("gameLibraryEnable"), "on");
            String gameLibraryPath = httpRequest.getPostParameter("gameLibraryPath");
            boolean gameScanEnable = Objects.equals(httpRequest.getPostParameter("gameScanEnable"), "on");
            int gameScanFrequencyTime = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("gameScanFrequencyTime")));
            ScanFrequencyEnum gameScanFrequencyType = ScanFrequencyEnum.valueOf(httpRequest.getPostParameter("gameScanFrequencyType"));
            boolean movieLibraryEnable = Objects.equals(httpRequest.getPostParameter("movieLibraryEnable"), "on");
            String movieLibraryPath = httpRequest.getPostParameter("movieLibraryPath");
            boolean movieScanEnable = Objects.equals(httpRequest.getPostParameter("movieScanEnable"), "on");
            boolean moviePreTranscodeEnable = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeEnable"), "on");
            boolean moviePreTranscodeOneFourFourP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeOneFourFourP"), "on");
            boolean moviePreTranscodeTwoFourZeroP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeTwoFourZeroP"), "on");
            boolean moviePreTranscodeThreeSixZeroP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeThreeSixZeroP"), "on");
            boolean moviePreTranscodeFourEightZeroP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeFourEightZeroP"), "on");
            boolean moviePreTranscodeSevenTwoZeroP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeSevenTwoZeroP"), "on");
            boolean moviePreTranscodeOneZeroEightZeroP = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeOneZeroEightZeroP"), "on");
            boolean moviePreTranscodeTwoK = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeTwoK"), "on");
            boolean moviePreTranscodeFourK = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeFourK"), "on");
            boolean moviePreTranscodeEightK = Objects.equals(httpRequest.getPostParameter("moviePreTranscodeEightK"), "on");
            int movieScanFrequencyTime = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("movieScanFrequencyTime")));
            ScanFrequencyEnum movieScanFrequencyType = ScanFrequencyEnum.valueOf(httpRequest.getPostParameter("movieScanFrequencyType"));
            String movieLibraryPreTranscodePath = httpRequest.getPostParameter("movieLibraryPreTranscodePath");
            boolean musicLibraryEnable = Objects.equals(httpRequest.getPostParameter("musicLibraryEnable"), "on");
            String musicLibraryPath = httpRequest.getPostParameter("musicLibraryPath");
            boolean musicScanEnable = Objects.equals(httpRequest.getPostParameter("musicScanEnable"), "on");
            boolean musicPreTranscodeEnable = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeEnable"), "on");
            boolean musicPreTranscodeSixFourK = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeSixFourK"), "on");
            boolean musicPreTranscodeNineSixK = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeNineSixK"), "on");
            boolean musicPreTranscodeOneTwoEightK = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeOneTwoEightK"), "on");
            boolean musicPreTranscodeThreeTwoZeroK = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeThreeTwoZeroK"), "on");
            boolean musicPreTranscodeOneFourOneOneK = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeOneFourOneOneK"), "on");
            int musicScanFrequencyTime = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("musicScanFrequencyTime")));
            ScanFrequencyEnum musicScanFrequencyType = ScanFrequencyEnum.valueOf(httpRequest.getPostParameter("musicScanFrequencyType"));
            String musicPreTranscodeLibraryPath = httpRequest.getPostParameter("musicPreTranscodeLibrary");
            boolean tvShowLibraryEnable = Objects.equals(httpRequest.getPostParameter("musicPreTranscodeOneFourOneOneK"), "on");
            String tvShowLibraryPath = httpRequest.getPostParameter("tvShowLibraryPath");
            boolean tvShowScanEnable = Objects.equals(httpRequest.getPostParameter("tvShowScanEnable"), "on");
            boolean tvShowPreTranscodeEnable = Objects.equals(httpRequest.getPostParameter("tvShowPreTranscodeEnable"), "on");
            boolean tvPreTranscodeOneFourFourP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeOneFourFourP"), "on");
            boolean tvPreTranscodeTwoFourZeroP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeTwoFourZeroP"), "on");
            boolean tvPreTranscodeThreeSixZeroP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeThreeSixZeroP"), "on");
            boolean tvPreTranscodeFourEightZeroP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeFourEightZeroP"), "on");
            boolean tvPreTranscodeSevenTwoZeroP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeSevenTwoZeroP"), "on");
            boolean tvPreTranscodeOneZeroEightZeroP = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeOneZeroEightZeroP"), "on");
            boolean tvPreTranscodeTwoK = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeTwoK"), "on");
            boolean tvPreTranscodeFourK = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeFourK"), "on");
            boolean tvPreTranscodeEightK = Objects.equals(httpRequest.getPostParameter("tvPreTranscodeEightK"), "on");
            int tvShowScanFrequencyTime = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("tvShowScanFrequencyTime")));
            ScanFrequencyEnum tvShowScanFrequencyType = ScanFrequencyEnum.valueOf(httpRequest.getPostParameter("tvShowScanFrequencyType"));
            String tvShowLibraryPreTranscodePath = httpRequest.getPostParameter("tvShowLibraryPreTranscodePath");
            String serverName = httpRequest.getPostParameter("serverName");
            String fileToUpload = httpRequest.getPostParameter("fileToUpload");
            boolean allowRegistration = Objects.equals(httpRequest.getPostParameter("allowRegistration"), "on");
            boolean showNewBooks = Objects.equals(httpRequest.getPostParameter("showNewBooks"), "on");
            boolean showNewGames = Objects.equals(httpRequest.getPostParameter("showNewGames"), "on");
            boolean showNewMovies = Objects.equals(httpRequest.getPostParameter("showNewMovies"), "on");
            boolean showNewMusic = Objects.equals(httpRequest.getPostParameter("showNewMusic"), "on");
            boolean showNewTvShows = Objects.equals(httpRequest.getPostParameter("showNewTvShows"), "on");
            boolean showPopularBooks = Objects.equals(httpRequest.getPostParameter("showPopularBooks"), "on");
            boolean showPopularGames = Objects.equals(httpRequest.getPostParameter("showPopularGames"), "on");
            boolean showPopularMovies = Objects.equals(httpRequest.getPostParameter("showPopularMovies"), "on");
            boolean showPopularMusic = Objects.equals(httpRequest.getPostParameter("showPopularMusic"), "on");
            boolean showPopularTvShows = Objects.equals(httpRequest.getPostParameter("showPopularTvShows"), "on");
            SearchMethodEnum searchMethod = SearchMethodEnum.valueOf(httpRequest.getPostParameter("searchMethod"));
            int maxSearchResults = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxSearchResults")));
            int maxBrowseResults = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxBrowseResults")));
            int fontSize = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("fontSize")));
            String fontType = httpRequest.getPostParameter("fontType");
            String fontColor = httpRequest.getPostParameter("fontColor");
            int cardWidth = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("cardWidth")));
            boolean stickyTopMenu = Objects.equals(httpRequest.getPostParameter("stickyTopMenu"), "on");
            boolean cacheEnable = Objects.equals(httpRequest.getPostParameter("cacheEnable"), "on");
            int apiCacheSize = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("apiCacheSize")));
            int databaseCacheSize = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("databaseCacheSize")));
            int pageCacheSize = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("pageCacheSize")));
            int maxAssetCacheAge = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxAssetCacheAge")));
            DatabaseTypeEnum databaseType = DatabaseTypeEnum.valueOf(httpRequest.getPostParameter("databaseType"));
            String databaseName = httpRequest.getPostParameter("databaseName");
            int minDatabaseConnections = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("minDatabaseConnections")));
            int maxDatabaseConnections = Integer.parseInt(Objects.requireNonNull(httpRequest.getPostParameter("maxDatabaseConnections")));
            return mainEndpointsController.saveSettings(
                httpRequest,
                interfaceNetworkUsage,
                defaultPlaybackQuality,
                debugEnabled,
                maintenanceMode,
                securityEnabled,
                compressionMethod,
                compressionQuality,
                securityIssuer,
                securitySecretKey,
                searchHost,
                searchKey,
                displayMode,
                encoderProgram,
                inspectorProgram,
                audioCodec,
                audioRate,
                audioPreset,
                videoContainer,
                videoCodec,
                videoPreset,
                tuneFilm,
                tuneAnimation,
                tuneGrain,
                stillImage,
                fastDecode,
                zeroLatency,
                fastStart,
                tunePsnr,
                tuneSsnr,
                videoCrf,
                blackBorderRemoval,
                cudaAcceleration,
                oneFourFourPTranscodeBitrate,
                twoFourZeroPTranscodeBitrate,
                threeSixZeroPTranscodeBitrate,
                fourEightZeroPTranscodeBitrate,
                sevenTwoZeroPTranscodeBitrate,
                oneZeroEightZeroPTranscodeBitrate,
                twoKTranscodeBitrate,
                fourKTranscodeBitrate,
                eightKTranscodeBitrate,
                showPoster,
                showName,
                showRuntime,
                showGenre,
                showMpaaRating,
                showUserRating,
                showLanguage,
                showReleaseDate,
                showActions,
                bookLibraryEnable,
                bookLibraryPath,
                bookScanEnable,
                bookScanFrequencyTime,
                bookScanFrequencyType,
                gameLibraryEnable,
                gameLibraryPath,
                gameScanEnable,
                gameScanFrequencyTime,
                gameScanFrequencyType,
                movieLibraryEnable,
                movieLibraryPath,
                movieScanEnable,
                moviePreTranscodeEnable,
                moviePreTranscodeOneFourFourP,
                moviePreTranscodeTwoFourZeroP,
                moviePreTranscodeThreeSixZeroP,
                moviePreTranscodeFourEightZeroP,
                moviePreTranscodeSevenTwoZeroP,
                moviePreTranscodeOneZeroEightZeroP,
                moviePreTranscodeTwoK,
                moviePreTranscodeFourK,
                moviePreTranscodeEightK,
                movieScanFrequencyTime,
                movieScanFrequencyType,
                movieLibraryPreTranscodePath,
                musicLibraryEnable,
                musicLibraryPath,
                musicScanEnable,
                musicPreTranscodeEnable,
                musicPreTranscodeSixFourK,
                musicPreTranscodeNineSixK,
                musicPreTranscodeOneTwoEightK,
                musicPreTranscodeThreeTwoZeroK,
                musicPreTranscodeOneFourOneOneK,
                musicScanFrequencyTime,
                musicScanFrequencyType,
                musicPreTranscodeLibraryPath,
                tvShowLibraryEnable,
                tvShowLibraryPath,
                tvShowScanEnable,
                tvShowPreTranscodeEnable,
                tvPreTranscodeOneFourFourP,
                tvPreTranscodeTwoFourZeroP,
                tvPreTranscodeThreeSixZeroP,
                tvPreTranscodeFourEightZeroP,
                tvPreTranscodeSevenTwoZeroP,
                tvPreTranscodeOneZeroEightZeroP,
                tvPreTranscodeTwoK,
                tvPreTranscodeFourK,
                tvPreTranscodeEightK,
                tvShowScanFrequencyTime,
                tvShowScanFrequencyType,
                tvShowLibraryPreTranscodePath,
                serverName,
                fileToUpload,
                allowRegistration,
                showNewBooks,
                showNewGames,
                showNewMovies,
                showNewMusic,
                showNewTvShows,
                showPopularBooks,
                showPopularGames,
                showPopularMovies,
                showPopularMusic,
                showPopularTvShows,
                searchMethod,
                maxSearchResults,
                maxBrowseResults,
                fontSize,
                fontType,
                fontColor,
                cardWidth,
                stickyTopMenu,
                cacheEnable,
                apiCacheSize,
                databaseCacheSize,
                pageCacheSize,
                maxAssetCacheAge,
                databaseType,
                databaseName,
                minDatabaseConnections,
                maxDatabaseConnections
            );
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> upload(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.upload(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> postUpload(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.postUpload(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }

    private @NotNull Promisable<HttpResponse> denied(@NotNull HttpRequest httpRequest) {
        try {
            return mainEndpointsController.getDeniedPage(httpRequest);
        } catch (Exception e) {
            if (settingsController.isDebug()) {
                e.printStackTrace();
            }
        }
        return HttpResponse.ofCode(500);
    }
}
