package com.crazy.booksoul.main.read;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crazy.booksoul.R;
import com.crazy.booksoul.main.ViewAdapterRead;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class ReadFragment extends Fragment {


    static Context context;


    static SharedPreferences sharedPreferences;

    static TabLayout tabLayout;
    static ViewPager viewPager;
    ViewAdapterRead viewPagerAdapter;
    public static int REQUEST_PERMISSIONS = 1;
    public RefreshEpub refreshEpub;
    private static ReadFragment instance;

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    List<List> bookList = new ArrayList<>();


    public ReadFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        context = getContext();
//        instance = getInstance();
//        context=getContext();
//        //RecyclerView
//        recyclerView = (RecyclerView) view.findViewById(R.id.internalBooks);
//        customAdapter = new CustomAdapter(context, bookList);
//        recyclerView.setAdapter(customAdapter);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL));
//
//        registerForContextMenu(recyclerView);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.viewpager);
        viewPagerAdapter = new ViewAdapterRead(getChildFragmentManager(), getContext());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


//        //Check Permission
//        if (!storagePermission()) {
//            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS);
//        } else {
//            ListBooksNCheckPreferences();
//        }
//        //Handle Epub File on Storage
//        try {
//            Uri uri = getActivity().getIntent().getData();
//            if (uri != null) {
//                FindTitle findTitle = new FindTitle();
//                String path = getPath(getContext(), uri);
//                Intent intentEpubViewer = new Intent(context, EpubViewer.class);
//                intentEpubViewer.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intentEpubViewer.putExtra("title", findTitle.FindTitle(path));
//                intentEpubViewer.putExtra("path", path);
//                for (int i = 0; i < bookList.size(); i++) {
//                    if (bookList.get(i).get(3).equals(path)) {
//                        intentEpubViewer.putExtra("title", bookList.get(i).get(0).toString());
//                        intentEpubViewer.putExtra("currentPage", bookList.get(i).get(6).toString());
//                        intentEpubViewer.putExtra("currentScroll", bookList.get(i).get(7).toString());
//                    }
//                }
//                context.startActivity(intentEpubViewer);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    //Convert URI to Actual Path
//    public static String getPath(final Context context, final Uri uri) {
//
//        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
//
//        // DocumentProvider
//        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
//            // ExternalStorageProvider
//            if (isExternalStorageDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                if ("primary".equalsIgnoreCase(type)) {
//                    return Environment.getExternalStorageDirectory() + "/" + split[1];
//                }
//
//                // TODO handle non-primary volumes
//            }
//            // DownloadsProvider
//            else if (isDownloadsDocument(uri)) {
//
//                final String id = DocumentsContract.getDocumentId(uri);
//                final Uri contentUri = ContentUris.withAppendedId(
//                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
//
//                return getDataColumn(context, contentUri, null, null);
//            }
//            // MediaProvider
//            else if (isMediaDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                Uri contentUri = null;
//                if ("image".equals(type)) {
//                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                } else if ("video".equals(type)) {
//                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                } else if ("audio".equals(type)) {
//                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                }
//
//                final String selection = "_id=?";
//                final String[] selectionArgs = new String[]{
//                        split[1]
//                };
//
//                return getDataColumn(context, contentUri, selection, selectionArgs);
//            }
//        }
//        // MediaStore (and general)
//        else if ("content".equalsIgnoreCase(uri.getScheme())) {
//            return getDataColumn(context, uri, null, null);
//        }
//        // File
//        else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            return uri.getPath();
//        }
//
//        return null;
//    }
//    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
//
//        Cursor cursor = null;
//        final String column = "_data";
//        final String[] projection = {
//                column
//        };
//
//        try {
//            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
//                    null);
//            if (cursor != null && cursor.moveToFirst()) {
//                final int column_index = cursor.getColumnIndexOrThrow(column);
//                return cursor.getString(column_index);
//            }
//        } finally {
//            if (cursor != null)
//                cursor.close();
//        }
//        return null;
//    }
//
//
//
//    //List Books and Check Shared Preferences
//    public void ListBooksNCheckPreferences() {
//        refreshEpub = new RefreshEpub(context, customAdapter, bookList);
//        try {
//            refreshEpub.readFileFromInternalStorage();
//            customAdapter.notifyDataSetChanged();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        if (sharedPreferences.getBoolean("firstrun", true)) {
//            sharedPreferences.edit().putBoolean("keep_screen_on", true).commit();
//            sharedPreferences.edit().putBoolean("auto_sync", true).commit();
//            sharedPreferences.edit().putBoolean("rotation_lock", true).commit();
//            sharedPreferences.edit().putBoolean("where_i_left", true).commit();
//            sharedPreferences.edit().putBoolean("built_in_web_browser", true).commit();
//            sharedPreferences.edit().putBoolean("firstrun", false).commit();
//        }
//        checkAutoSync();
//        checkSharedPreferences();
//    }
//
//
//    //Check Shared Preferences
//    public void checkAutoSync() {
//        if (sharedPreferences.getBoolean("auto_sync", false) == true) {
//            refreshEpub.new refreshBooks().execute();
//        } else {
//            customAdapter.refreshingDone(bookList);
//        }
//    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_PERMISSIONS) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                ListBooksNCheckPreferences();
//            } else {
//                Toast.makeText(context, "Permission is not granted", Toast.LENGTH_LONG).show();
//                getActivity().finish();
//            }
//        }
//    }
//    public void checkSharedPreferences() {
//        if (sharedPreferences.getBoolean("keep_screen_on", false) == true) {
//            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        } else {
//            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        }
//        if (sharedPreferences.getBoolean("rotation_lock", false) == true) {
//            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
//            } else {
//                getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
//            }
//        } else {
//            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
//        }
//    }
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (storagePermission()) {
//            checkSharedPreferences();
//        }
//    }
//
//    public static boolean isExternalStorageDocument(Uri uri) {
//        return "com.android.externalstorage.documents".equals(uri.getAuthority());
//    }
//    public static boolean isDownloadsDocument(Uri uri) {
//        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
//    }
//    public static boolean isMediaDocument(Uri uri) {
//        return "com.android.providers.media.documents".equals(uri.getAuthority());
//    }
//
//
//
//    //Custom Shared Preferences
//    public static final String myPref = "preferenceName";
//    public String getFromPreferences(String key) {
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(myPref, 0);
//        String str = sharedPreferences.getString(key, "null");
//        return str;
//    }
//    public void setToPreferences(String key, String thePreference) {
//        SharedPreferences.Editor editor = getActivity().getSharedPreferences(myPref, 0).edit();
//        editor.putString(key, thePreference);
//        editor.commit();
//    }
//    //Check Storage Permission
//    public static boolean storagePermission() {
//        return (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
//    }
//
//    public static ReadFragment getInstance() {
//        return instance;
//    }

    }



}