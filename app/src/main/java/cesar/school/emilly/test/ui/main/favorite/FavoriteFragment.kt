package cesar.school.emilly.test.ui.main.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cesar.school.emilly.test.data.local.DatabaseApp
import cesar.school.emilly.test.data.local.model.Favorite
import cesar.school.emilly.test.databinding.FragmentFavoriteBinding
import cesar.school.emilly.test.extension.toPx
import cesar.school.emilly.test.util.MarginItemDecoration

class FavoriteFragment: Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteAdapter by lazy { FavoriteAdapter {
    } }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dao = DatabaseApp.getInstance(requireContext()).getFavoriteDao()

        val favorite = Favorite(2,"Recife", "BR")
        dao.insert(favorite)

        dao.getAll().forEach {
            Log.d("DB", "onActivityCreated: $it")
        }

        binding.rvCitiesFavorite.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = favoriteAdapter
            addItemDecoration(MarginItemDecoration(16.toPx()))
        }



    }

}