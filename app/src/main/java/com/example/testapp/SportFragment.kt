package com.example.testapp

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.databinding.FragmentDietBinding
import com.example.testapp.databinding.FragmentSplashBinding

class SportFragment : Fragment() {

    private var _binding: FragmentDietBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDietBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutGavi.setOnClickListener {
            showDialog("Gavi", "A complete midfielder with a winning character to match, Gavi made his fateful move to FC Barcelona for the 2015/16 season. He first represented the blaugranes at U12 level before moving through the youth categories quickly to reach the U19 squad. After impressing quickly it was not long before he made his debut for Barça B and in preseason in 2020 coach Ronald Koeman decided to include him with the first team players at the Club. ")
        }

        binding.layoutBelingham.setOnClickListener {
            showDialog("Jude Bellingham", "Jude Victor William Bellingham (born 29 June 2003) is an English professional footballer who plays as a midfielder for Bundesliga club Borussia Dortmund and the England national team.\n" +
                    "\n" +
                    "Bellingham joined Birmingham City as an under-8, became the club's youngest ever first-team player when he made his senior debut in August 2019, at the age of 16 years, 38 days,[3] and played regularly during the 2019–20 season. He joined Borussia Dortmund in July 2020, and in his first competitive match became their youngest ever goalscorer.")
        }

        binding.layoutMusi.setOnClickListener {
            showDialog("Jamal Musiala", "Jamal Musiala (born 26 February 2003) is a German professional footballer who plays as an attacking midfielder or winger for Bundesliga club Bayern Munich and the Germany national team.\n" +
                    "\n" +
                    "Born in Germany to a Nigerian father and German mother, he was raised from the age of seven in England. Musiala represented both Germany and England at youth level, and eventually pledged his allegiance to the Germany national team for future games in February 2021, representing the side at UEFA Euro 2020 and the 2022 FIFA World Cup.[4][5]")
        }

        binding.layoutPedri.setOnClickListener {
            showDialog("Pedri", "On September 2, 2019, FC Barcelona and Las Palmas reached an agreement for the transfer of Pedri. However, the Canarian player didn't join the blaugranes until August 2020. Born in Tegueste, Tenerife, on November 25, 2002, he began his football career in the team from his hometown. \n" +
                    "\n" +
                    "Later, he joined Laguna Youth and, from 2018, he began playing in the youth teams at UD Las Palmas. He excelled there and in the 2019/20 season he was a starter in the first team and the most used player across the season: 34 Segunda División A games and four goals.")
        }

        binding.layoutSaka.setOnClickListener {
            showDialog("Bukayo Saka", "Bukayo Ayoyinka T. M. Saka[4] (born 5 September 2001) is an English professional footballer who plays as a winger, left-back, or midfielder for Premier League club Arsenal and the England national team. Saka is known for his attacking incisiveness and creativity, and is often considered one of the best young football players in the world.[5][6][7]")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}