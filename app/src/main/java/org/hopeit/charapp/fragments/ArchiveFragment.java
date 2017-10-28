package org.hopeit.charapp.fragments;


import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.AnyRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.hopeit.charapp.R;
import org.hopeit.charapp.utils.Content;

import java.util.ArrayList;
import java.util.List;


public class ArchiveFragment extends Fragment {
    
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static ArchiveFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ArchiveFragment fragment = new ArchiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        Log.i("TAG", getActivity().toString());

    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.archiveitem_recycler_content);
        List<Content> toDisplay = new ArrayList<>();
        toDisplay.add(new Content("Sample content", null));

        toDisplay.add(new Content("Secondary sample content", drawableToUri(getActivity(), R.drawable.drawing_girl))  );
        toDisplay.add(new Content("Secondary sample content", drawableToUri(getActivity(), R.drawable.drawing_girl))  );
        toDisplay.add(new Content("Secondary sample content", drawableToUri(getActivity(), R.drawable.drawing_girl))  );
        toDisplay.add(new Content("Secondary sample content", drawableToUri(getActivity(), R.drawable.drawing_girl))  );
        toDisplay.add(new Content("Secondary sample content", drawableToUri(getActivity(), R.drawable.drawing_girl))  );

        recyclerView.setAdapter(
                new ContentAdapter(toDisplay)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_archive, container, false);
        TextView textView = (TextView) view.findViewById(R.id.content);
        return view;
    }



    private Uri drawableToUri(@NonNull Context context, @AnyRes int drawableId) {
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId) );
        return imageUri;
    }

    private class ContentAdapter extends
            RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        private List<Content> contentList;
        private Context context;

        public ContentAdapter(List<Content> contentList) {
            this.contentList = contentList;
            this.context = ArchiveFragment.this.getActivity();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View contactView = inflater.inflate(R.layout.item_content, parent, false);
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Content content = contentList.get(position);

            CardView card = holder.card;
            TextView textContentView = holder.textContentView;
            textContentView.setText(content.getTextContent());
            ImageView imageContentView = holder.imageContentView;
            imageContentView.setImageURI(content.getImageContent());
        }

        @Override
        public int getItemCount() {
            return contentList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            private CardView card;
            private TextView textContentView;
            private ImageView imageContentView;

            private ViewHolder(View itemView) {
                super(itemView);
                card = (CardView)itemView.findViewById(R.id.card);
                textContentView = (TextView) itemView.findViewById(R.id.text_content);
                imageContentView = (ImageView) itemView.findViewById(R.id.image_content);
            }
        }
    }


}
