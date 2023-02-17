package info.xbet.x.sports

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapp.databinding.FragmentDietBinding

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

        binding.layoutKvara.setOnClickListener {
            showDialog("Khvicha Kvaratskhelia", "Khvicha Kvaratskhelia (Georgian: ხვიჩა კვარაცხელია, romanized: khvicha k'varatskhelia; born 12 February 2001, in short Kvara) is a Georgian professional footballer who plays as a winger for Serie A club Napoli and the Georgia national team.[1]\n" +
                    "\n" +
                    "Club career\n" +
                    "Early career\n" +
                    "Coming through the youth system, Kvaratskhelia began his senior career at Dinamo Tbilisi in 2017, before joining Rustavi one year later.[2]\n" +
                    "\n" +
                    "Due to his performance at the Georgian U17 team, in 2017 Kvaratskhelia became the first winner of the newly introduced Aleksandre Chivadze golden medal, annually awarded by GFF to talented young players.[3] The next year he received a silver medal among U19 players.[4]\n" +
                    "\n" +
                    "In 2018, The Guardian named Kvaratskhelia among 60 best young players worldwide.[5]")
        }

        binding.layoutCamavinga.setOnClickListener {
            showDialog("Eduardo Camavinga", "Eduardo Celmi Camavinga (born 10 November 2002) is a French professional footballer who plays as a midfielder for La Liga club Real Madrid. Born in Angola, he plays for the France national team.\n" +
                    "\n" +
                    "Early life\n" +
                    "Camavinga was born in a refugee camp in Cabinda, Angola in 2002, to Congolese parents from Brazzaville.[4][5] He has five siblings. His family moved to France when he was two. They moved to Fougères, where he grew up. He practiced judo for a time, before giving it up to focus solely on football. In 2013, the Camavingas' house was burnt down, destroying most of the family's property; Camavinga stated that this was a source of motivation that pushed him to pursue a career in football and help his family.[6]\n" +
                    "\n" +
                    "On 7 July 2020, he obtained the Baccalauréat ES (Economic and Social) without mention.[7][8]")
        }

        binding.layoutGarnacho.setOnClickListener {
            showDialog("Alejandro Garnacho", "Alejandro Garnacho Ferreyra (born 1 July 2004) is a professional footballer who plays as a winger for Premier League club Manchester United.\n" +
                    "\n" +
                    "Garnacho joined Manchester United's youth system from Atlético Madrid in October 2020. He won the FA Youth Cup and the Jimmy Murphy Young Player of the Year award in May 2022. The month before, he had made his first-team debut at the age of 17, in a Premier League game against Chelsea.\n" +
                    "\n" +
                    "Garnacho initially played youth international football for Spain, the country of his birth, before making his debut for Argentina at under-20 level in 2022. He has been called up to the senior Argentina squad but has yet to make an appearance.")
        }

        binding.layoutMartinelli.setOnClickListener {
            showDialog("Gabriel Martinelli", "Gabriel Teodoro Martinelli Silva (born 18 June 2001), known as Gabriel Martinelli, is a Brazilian professional footballer who plays as a forward for Premier League club Arsenal and the Brazil national team.\n" +
                    "\n" +
                    "Born and raised in Guarulhos, Martinelli began his senior club career playing for Ituano and signed for Arsenal in July 2019, aged 18. He won the FA Cup in his debut season.\n" +
                    "\n" +
                    "At the international level, Martinelli represents the Brazil under-23s. He helped Brazil win an Olympic Gold in men's football at the 2020 Summer Olympics. He made his senior debut in 2022 and was part of Brazil's squad at the 2022 FIFA World Cup.")
        }

        binding.layoutMukoko.setOnClickListener {
            showDialog("Youssoufa Moukoko", "Youssoufa Moukoko (born 20 November 2004) is a German professional footballer who plays as a striker for Bundesliga club Borussia Dortmund and the Germany national team. He is known for his scoring ability at younger age levels.[3]\n" +
                    "\n" +
                    "Club career\n" +
                    "Early career\n" +
                    "Moukoko played in the under-13 team of FC St. Pauli from 2014 to 2016 and scored 23 goals in 13 games as a striker in the U15.[citation needed]\n" +
                    "\n" +
                    "In July 2016, he was transferred to Borussia Dortmund's youth academy. He played as the only 13-year-old in the Under 17 Bundesliga for Dortmund. Moukoko moved up to the under-19 team for the 2019–20 season at the age of 14, scoring six goals in his first match in the Under 19 Bundesliga in a 9–2 win against Wuppertaler SV.[4] He completed his first UEFA Youth League match on 17 September 2019 against FC Barcelona, becoming the youngest player to be fielded in the competition.[5] On 23 October 2019, Moukoko scored the opening goal in a game against Inter Milan, making him the youngest scorer in the Youth League.[6] In total, Moukoko scored 141 goals in just 88 games for Dortmund's under-17 and under-19 sides. [7]")
        }

        binding.layoutSaliba.setOnClickListener {
            showDialog("William Saliba", "William Alain André Gabriel Saliba (born 24 March 2001) is a French professional footballer who plays as a centre-back for Premier League club Arsenal and the France national team.\n" +
                    "\n" +
                    "Club career\n" +
                    "Saint-Étienne\n" +
                    "Saliba began playing football at the age of six, coached by the father of Kylian Mbappé.[4] He eventually moved south to Saint-Étienne in 2016,[5] and signed his first contract at age 17, in May 2018.[6] Saliba then made his professional debut on 25 September 2018, featuring in a 3–2 Ligue 1 win over Toulouse.[7] He made 13 starting appearances in his first season at Saint-Étienne.[8]")
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