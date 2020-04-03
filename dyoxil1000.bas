B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=6.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
Dim sc As ScrollView
Dim ili As Button
Dim ousia As Button
Dim simansi As Button
Dim pixi As Button

Dim lista As Button

	Private katigor As Button
	
	Dim fakos As Label
	
	Private mple As ImageView
	Private simanseislabel As Label
	Private listabel As Label
	Private katigorlabel As Label
	Private ousialabel As Label
	Private ililabel As Label






	Dim Panel As Panel

	Dim clv2 As CustomListView
	
	Dim Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("adr.bal")
    

	
		
		
 simanseislabel.Top = 3%y
simanseislabel.left = 3.5%x
simanseislabel.height = 27.5%y
simanseislabel.Width  = 45%x
   simansi.Top = 3%y
simansi.left = 3%x
simansi.height = 28%y
simansi.Width  = 45%x



''PANW DEXIA MESH
lista.Top = 3%y
lista.left = 51.5%x
lista.height = 13%y
lista.Width  = 21.25%x

listabel.Top = 3%y
listabel.left = 51.75%x
listabel.height = 13%y
listabel.Width  = 21.25%x



katigor.Top = 18%y
katigor.left = 51.50%x
katigor.height = 13%y
katigor.Width  = 21.25%x

katigorlabel.Top = 18%y
katigorlabel.left = 51.75%x
katigorlabel.height = 13%y
katigorlabel.Width  = 21.25%x
'PANW DEXIA AKRH
ousia.Top = 3%y
ousia.left = 75.75%x
ousia.height = 13%y
ousia.Width  = 21.25%x
ousialabel.Top = 3%y
ousialabel.left = 76%x
ousialabel.height = 13%y
ousialabel.Width  = 21.25%x

ili.Top = 18%y
ili.left = 75.75%x
ili.height = 13%y
ili.Width  = 21.25%x
ililabel.Top = 18%y
ililabel.left = 76%x
ililabel.height = 13%y
ililabel.Width  = 21.25%x
   

mple.top = 93%y
mple.left = 3%x
mple.width = 94%x
mple.height = 7%y


	
	

	
	
	
	
  
  
clv2.Initialize(Me, "clv2")
	Panel2.AddView(clv2.AsView, 0%x, 0%y,94%x ,57.5%y )
	 Panel2.Top = 33%y
  Panel2.Left = 3%x
  Panel2.Width = 94%x
  Panel2.Height = 57.5%y
	clv2.DefaultTextBackgroundColor = Colors.DarkGray

 
 clv2.AddTextItem("2901	Κατηγορία 2	Χλωριούχο βρώμιο	   " ,"")
 clv2.AddTextItem("2902	Κατηγορία 6.1	Φυτοφάρμακα , υγρά, τοξικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2903	Κατηγορία 6.1	Φυτοφάρμακα, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	     " ,"")
 clv2.AddTextItem("2904	Κατηγορία 8	Chlorophenolates , υγρό ή φαινολικά, υγρό	     " ,"")
 clv2.AddTextItem("2905	Κατηγορία 8	Chlorophenolates, στερεά ή φαινολικά, στερεά	     " ,"")
 clv2.AddTextItem("2907	Κατηγορία 4.1	Δινιτρικό ισοσορβίδιο μίγμα με όχι λιγότερο από 60 τοις εκατό γαλακτόζη, μαννόζη, άμυλο ή όξινο φωσφορικό ασβέστιο	     " ,"")
 clv2.AddTextItem("2908	Κατηγορία 7	Ραδιενεργό υλικό , εξαιρούμενο κόλο - κενή συσκευασία	     " ,"")
 clv2.AddTextItem("2909	Κατηγορία 7	Ραδιενεργό υλικό, εξαιρούμενο-είδη συσκευασίας που κατασκευάζονται από φυσικό ή εξαντλημένο ουράνιο ή φυσικό θόριο	  " ,"")   
 clv2.AddTextItem("2910	Κατηγορία 7	Ραδιενεργό υλικό, εξαιρούμενο ποσότητα πακέτο περιορισμένη υλικού	     " ,"")
 clv2.AddTextItem("2911	Κατηγορία 7	Ραδιενεργό υλικό, εξαιρούμενο κόλο, όργανα ή είδη	     " ,"")
 clv2.AddTextItem("2912	Κατηγορία 7	Ραδιενεργό υλικό, χαμηλή σχετική δραστικότητα (LSA-I) μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")   
 clv2.AddTextItem("2913	Κατηγορία 7	Ραδιενεργό υλικό, επιφανειακά μολυσμένα αντικείμενα (SCO-I ή SCO-II) μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")	   
 clv2.AddTextItem("2915	Κατηγορία 7	Ραδιενεργό υλικό, πληκτρολογήστε ένα πακέτο μη-ειδικό έντυπο, μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")   
 clv2.AddTextItem("2916	Κατηγορία 7	Ραδιενεργό υλικό, κόλου Τύπου B (U) μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")
 clv2.AddTextItem("2917	Κατηγορία 7	Ραδιενεργό υλικό, κόλου Τύπου B (M) μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")	   
 clv2.AddTextItem("2918	Κατηγορία 7	Ραδιενεργό υλικό, σχάσιμο, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2919	Κατηγορία 7	Ραδιενεργό υλικό, μεταφέρονται υπό ειδική ρύθμιση, μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")	   
 clv2.AddTextItem("2920	Κατηγορία 8	Διαβρωτικά υγρά, εύφλεκτα, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2921	Κατηγορία 8	Διαβρωτικά στερεά, εύφλεκτα, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2922	Κατηγορία 8	Διαβρωτικά υγρά, τοξικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2923	Κατηγορία 8	Διαβρωτικών στερεών, τοξικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2924	Κατηγορία 3	Εύφλεκτα υγρά, διαβρωτικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2925	Κατηγορία 4.1	Εύφλεκτα στερεά, διαβρωτικά, οργανικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2926	Κατηγορία 4.1	Εύφλεκτα στερεά, τοξικά, οργανικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2927	Κατηγορία 6.1	Τοξικό υγρό, διαβρωτικό, οργανικά, ε.α.ο. ή τοξικό υγρό, διαβρωτικό, οργανικά, ε.α.ο. Εισπνοή κινδύνου, ομάδα συσκευασίας I, Ζώνη Α ή Β  " ,"")	   
 clv2.AddTextItem("2928	Κατηγορία 6.1	Τοξικά στερεά, διαβρωτικά, οργανικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2929	Κατηγορία 6.1	Τοξικό υγρό, εύφλεκτο, οργανικά, ε.α.ο. ή τοξικό υγρό, εύφλεκτο, οργανικά, ε.α.ο. Εισπνοή κινδύνου, ομάδα συσκευασίας I, Ζώνη Α ή Β	     " ,"")
 clv2.AddTextItem("2930	Κατηγορία 6.1	Τοξικά στερεά, εύφλεκτα, οργανικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2931	Κατηγορία 6.1	Θειικό βαναδυλική	     " ,"")
 clv2.AddTextItem("2933	Κατηγορία 3	Xλωροπροπιονικό	     " ,"")
 clv2.AddTextItem("2934	Κατηγορία 3.3	Ισοπροπυλ-χλωροπροπιονικό	     " ,"")
 clv2.AddTextItem("2935	Κατηγορία 3.3	Αιθύλιο χλωροπροπιονικό	     " ,"")
 clv2.AddTextItem("2936	Κατηγορία 6.1	Θειογαλακτικό οξύ	     " ,"")
 clv2.AddTextItem("2937	Κατηγορία 6.1	άλφα-μεθυλοβενζυλο αλκοόλη	     " ,"")
 clv2.AddTextItem("2940	Κατηγορία 4.2	Roanilines	  " ,"")   
 clv2.AddTextItem("2942	Κατηγορία 6.1	Tριφθορομεθυλανιλίνη	  " ,"")   
 clv2.AddTextItem("2943	Κατηγορία 3.3	Τετραϋδροφουρφουρυλαμίνης	     " ,"")
 clv2.AddTextItem("2945	Κατηγορία 8	Ν-μεθυλοβουτυλαμίνη	     " ,"")
 clv2.AddTextItem("2946	Κατηγορία 6.1	Κατηγορία 2-αμινο-Κατηγορία 5-diethylaminopentane  " ,"")	   
 clv2.AddTextItem("2947	Κατηγορία 3.3	Ισοπροπυλική χλωροξικόν	     " ,"")
 clv2.AddTextItem("2948	Κατηγορία 6.1	Κατηγορία 3-τριφθορομεθυλανιλίνη	     " ,"")
 clv2.AddTextItem("2949	Κατηγορία 8	Θειούχο νάτριο , με όχι λιγότερο από 25 τοις εκατό νερό κρυστάλλωσης	    " ,"")
 clv2.AddTextItem("2950	Κατηγορία 4.3	Μαγνήσιο κοκκία, επικαλυμμένα όχι μέγεθος σωματιδίων μικρότερο από 149 μικρόμετρα  " ,"")	   
 clv2.AddTextItem("2956	Κατηγορία 4.1	Κατηγορία 5-τριτ-βουτυλο-Κατηγορία 2,Κατηγορία 4,Κατηγορία 6-τρινιτρο-μ-ξυλόλιο ή μοσχοξυλόλιο	  " ,"")   
 clv2.AddTextItem("2965	Κατηγορία 4.3	Τριφθοριούχο βόριο αιθερικό διμεθυλο	     " ,"")
 clv2.AddTextItem("2966	Κατηγορία 6.1	Thiogylcol	     " ,"")
 clv2.AddTextItem("2967	Κατηγορία 8	Σουλφαμικό οξύ	     " ,"")
 clv2.AddTextItem("2968	Κατηγορία 4.3	Maneb σταθεροποιηθεί ή παρασκευάσματα Maneb, σταθεροποιημένο έναντι της αυτο-θέρμανσης  " ,"")	   
 clv2.AddTextItem("2969	Κατηγορία 9	Castor φασόλια ή Castor γεύμα ή Castor ελαιοπυρήνα ή Castor νιφάδα	      " ,"")
 clv2.AddTextItem("2974	Κατηγορία 7	Ραδιενεργό υλικό, ειδική μορφή, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2975	Κατηγορία 7	Θόριο μέταλλο, πυροφορικά	     " ,"")
 clv2.AddTextItem("2976	Κατηγορία 7	Νιτρικό θόριο , στερεό	     " ,"")
 clv2.AddTextItem("2977	Κατηγορία 7	Εξαφθοριούχο ουράνιο ,  εξαφθοριούχο ουράνιο, σχάσιμο	  " ,"")   
 clv2.AddTextItem("2978	Κατηγορία 7	Εξαφθοριούχο ουράνιο,  εξαφθοριούχο ουράνιο μη σχάσιμο ή σχάσιμο εξαιρούμενο  " ,"")
 clv2.AddTextItem("2979	Κατηγορία 7	Ουράνιο μέταλλο, πυροφορικά	     " ,"")
 clv2.AddTextItem("2980	Κατηγορία 7	Νιτρικού ουρανυλίου λύση εξαϋδρίτου	     " ,"")
 clv2.AddTextItem("2981	Κατηγορία 7	Νιτρικό ουρανύλιο, στερεό	     " ,"")
 clv2.AddTextItem("2982	Κατηγορία 7	Ραδιενεργό υλικό, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2983	Κατηγορία 3.1	Οξείδιο  αιθυλενίου και οξειδίου  προπυλενίου μίγματα με όχι περισσότερο από 30 τοις εκατό αιθυλενοξειδίου	     " ,"")
 clv2.AddTextItem("2984	Κατηγορία 5.2	Υπεροξείδιο  υδρογόνου   " ,"")
 clv2.AddTextItem("2985	Κατηγορία 3.2	Χλωροσιλάνι , εύφλεκτα, διαβρωτικά, ε.α.ο.	  " ,"")   
 clv2.AddTextItem("2986	Κατηγορία 3	Χλωροσιλάνι, διαβρωτικές, εύφλεκτες, ε.α.ο.	  " ,"")   
 clv2.AddTextItem("2987	Κατηγορία 8	Χλωροσιλάνι, διαβρωτικά, ε.α.ο.	     " ,"")
 clv2.AddTextItem("2988	Κατηγορία 4.3	Χλωροσιλανίων, αντιδρούν με  νερό, εύφλεκτα, διαβρωτικά, ε.α.ο.	  " ,"")   
 clv2.AddTextItem("2989	Κατηγορία 4.1	Μόλυβδος φωσφίτης , διβασικό	     " ,"")
 clv2.AddTextItem("2990	Κατηγορία 9	Σωστικά, φουσκώνει	     " ,"")
 clv2.AddTextItem("2991	Κατηγορία 3	Καρβαμιδικό παρασιτοκτόνο , υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	     " ,"")
 clv2.AddTextItem("2992	Κατηγορία 6.1	Καρβαμικού παρασιτοκτόνα, υγρά, τοξικά	     " ,"")
 clv2.AddTextItem("2993	Κατηγορία 3	Αρσενικού παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C  " ,"")	   
 clv2.AddTextItem("2994	Κατηγορία 6.1	Αρσενικού παρασιτοκτόνα, υγρά, τοξικά	     " ,"")
 clv2.AddTextItem("2995	Κατηγορία 6.1	Οργανοχλωριωμένα παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	     " ,"")
 clv2.AddTextItem("2996	Κατηγορία 6.1	Οργανοχλωριωμένα παρασιτοκτόνο, υγρό, τοξικό	     " ,"")
 clv2.AddTextItem("2997	Κατηγορία 6.1	Τριαζίνης παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	     " ,"")
 clv2.AddTextItem("2998	Κατηγορία 6.1	Παρασιτοκτόνα τριαζίνης, υγρό, toxick  " ,"")

End Sub

Sub clv1_ItemClick (Index As Int, Value As Object)
	Activity.Title = Value
End Sub

Sub CreateListItem(Text As String, Width As Int, Height As Int) As Panel
	Dim p As Panel
	p.Initialize("")
	p.Color = Colors.Black
	Dim b As Button
	b.Initialize("button") 'all buttons click events will be handled with Sub Button_Click
	Dim chk As CheckBox
	chk.Initialize("")
	Dim lbl As Label
	lbl.Initialize("")
	lbl.Gravity = Bit.Or(Gravity.CENTER_VERTICAL, Gravity.LEFT)
	lbl.Text = Text
	lbl.TextSize = 16
	lbl.TextColor = Colors.White
	b.Text = "Click"
	p.AddView(lbl, 5dip, 2dip, 150dip, Height - 4dip) 'view #0
	p.AddView(b, 155dip, 2dip, 110dip, Height - 4dip) 'view #1
	p.AddView(chk, 280dip, 2dip, 50dip, Height - 4dip) 'view #2
	Return p
End Sub



Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
Activity.Finish
End Sub
Sub ili_Click
	StartActivity("ilika")
End Sub
Sub ousia_Click
	StartActivity("ousies")
End Sub
Sub pixi_Click
	StartActivity("pixida")
End Sub

Sub lista_Click
	StartActivity("listaousies")
End Sub

Sub katigor_Click
	StartActivity("katigoriess")
End Sub
Sub gpss_Click
	
StartActivity("gpssingal")
End Sub

Sub simanseislabel_Click
	StartActivity("Main")
End Sub
Sub listabel_Click
	StartActivity("listaousies")
End Sub
Sub katigorlabel_Click
	StartActivity("katigoriess")
End Sub
Sub ousialabel_Click
	StartActivity("ousies")
End Sub
Sub ililabel_Click
	StartActivity("ilika")
End Sub

Sub simansi_Click
	StartActivity("Main")
End Sub


Sub Activity_KeyPress (KeyCode As Int) As Boolean
    If KeyCode = KeyCodes.KEYCODE_BACK Then
      
             Activity.Finish
       End If
End Sub
