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

 
   clv2.AddTextItem("3005	Κατηγορία 6.1	Θειοκαρβαμικού παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	   " ,"")
   clv2.AddTextItem("3006	Κατηγορία 6.1	Θειοκαρβαμιδικό παρασιτοκτόνο, υγρό, τοξικό	     " ,"")
   clv2.AddTextItem("3009	Κατηγορία 6.1	Χαλκός φυτοφάρμακα βάση, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	 " ,"")   
   clv2.AddTextItem("3010	Κατηγορία 6.1	Χαλκός παρασιτοκτόνα με βάση υγρό, τοξικό	    " ,"")
   clv2.AddTextItem("3011	Κατηγορία 6.1	Ο υδράργυρος φυτοφάρμακα που βασίζονται, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	    " ,"")
   clv2.AddTextItem("3012	Κατηγορία 6.1	Ο υδράργυρος φυτοφάρμακα που βασίζονται, υγρά, τοξικά	    " ,"")
   clv2.AddTextItem("3013	Κατηγορία 6.1	Υποκαταστημένα νιτροφαινόλη φυτοφάρμακα, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	 " ,"")   
   clv2.AddTextItem("3014	Κατηγορία 6.1	Υποκατεστημένες φυτοφάρμακα νιτροφαινόλης, υγρά, τοξικά	    " ,"")
   clv2.AddTextItem("3015	Κατηγορία 6.1	Bipyridilium παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C " ,"")	   
   clv2.AddTextItem("3016	Κατηγορία 6.1	Bipyridilium παρασιτοκτόνα, υγρά, τοξικά	    " ,"")
   clv2.AddTextItem("3017	Κατηγορία 6.1	Οργανοφωσφορικές φυτοφάρμακα, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	    " ,"")
   clv2.AddTextItem("3018	Κατηγορία 6.1	Οργανοφωσφορικές φυτοφάρμακα, υγρά, τοξικά	    " ,"")
   clv2.AddTextItem("3019	Κατηγορία 6.1	Οργανοκασσιτερικές φυτοφάρμακα, υγρό, τοξικό, εύφλεκτο, σημείο ανάφλεξης όχι μικρότερο από 23 ° C	    " ,"")
   clv2.AddTextItem("3020	Κατηγορία 6.1	Οργανοκασσιτερικές φυτοφάρμακα, υγρό, τοξικό	    " ,"")
   clv2.AddTextItem("3021	Κατηγορία 3	Φυτοφάρμακα, υγρό, εύφλεκτο, τοξικό, σημείο ανάφλεξης μικρότερο από 23 ° C	    " ,"")
   clv2.AddTextItem("3022	Κατηγορία 3	Κατηγορία 1,Κατηγορία 2-βουτυλενοξείδιο , σταθεροποιημένο	    " ,"")
   clv2.AddTextItem("3023	Κατηγορία 6.1	Κατηγορία 2-μεθυλ-Κατηγορία 2-επτανοθειόλη	    " ,"")
   clv2.AddTextItem("3024	Κατηγορία 3	Η κουμαρίνη παράγωγο παρασιτοκτόνα, υγρά, εύφλεκτα, τοξικά, σημείο ανάφλεξης μικρότερο από 23 ° C	 " ,"")   
   clv2.AddTextItem("3025	Κατηγορία 6.1	Παράγωγο κουμαρίνης παρασιτοκτόνα, υγρά, τοξικά, εύφλεκτα, σημείο ανάφλεξης όχι μικρότερο από 23 ° C " ,"")	   
   clv2.AddTextItem("3026	Κατηγορία 6.1	Παράγωγο κουμαρίνης παρασιτοκτόνα, υγρά, τοξικά	    " ,"")
   clv2.AddTextItem("3027	Κατηγορία 6.1	Παράγωγο κουμαρίνης παρασιτοκτόνα, στερεά, τοξικά	    " ,"")
   clv2.AddTextItem("3028	Κατηγορία 8	Μπαταρίες , ξηρά, που περιέχουν υδροξείδιο του καλίου στερεό, ηλεκτρικό, αποθήκευση	    " ,"")
   clv2.AddTextItem("3048	Κατηγορία 6.1	Φωσφορούχο αλουμίνιο φυτοφάρμακα	    " ,"")
   clv2.AddTextItem("3049	Κατηγορία 4.2	Μεταλλικά αλκυλο αλογονίδια , αντιδρώντα με νερό, ε.α.ο. ή μέταλλο αρυλο αλογονίδια, αντιδρούν  " ,"")
   clv2.AddTextItem("3052	Κατηγορία 4.2	Aλκυλαλογονίδια	    " ,"")
   clv2.AddTextItem("3053	Κατηγορία 4.2              Μαγνήσιο 	    " ,"")
   clv2.AddTextItem("3054	Κατηγορία 3	Κυκλοεξυλο μερκαπτάνη	    " ,"")
   clv2.AddTextItem("3055	Κατηγορία 8	Aμινοαιθοξυ αιθανόλη	    " ,"")
   clv2.AddTextItem("3056	Κατηγορία 3	Kεπταλδεΰδη	   " ,"") 
   clv2.AddTextItem("3057	Κατηγορία 2	Τριφθοροακετυλ χλωρίδιο	    " ,"")
   clv2.AddTextItem("3064	Κατηγορία 3	Νιτρογλυκερίνη , διάλυμα σε αλκοόλη, " ,"")
   clv2.AddTextItem("3065	Κατηγορία 3	Αλκοολούχα ποτά	    " ,"")
   clv2.AddTextItem("3066	Κατηγορία 8	Paint ή σχετιζόμενο με χρώμα, υλικό	    " ,"")
   clv2.AddTextItem("3070	Κατηγορία 2.2	Οξείδιο του αιθυλενίου και διχλωροδιφθορομεθάνιο  " ,"")	   
   clv2.AddTextItem("3071	Κατηγορία 6.1	Μερκαπτάνες , υγρό, τοξικό, εύφλεκτο " ,"")
   clv2.AddTextItem("3072	Κατηγορία 9	Σωστικά, δεν φουσκώνει περιέχουν επικίνδυνα εμπορεύματα, όπως ο εξοπλισμός	   " ,"") 
   clv2.AddTextItem("3073	Κατηγορία 6.1	Βινυλοπυριδίνες , αναστέλλεται	    " ,"")
   clv2.AddTextItem("3076	Κατηγορία 4.2	Aλουμινίο αλκυλο υδρίδια 	    " ,"")
   clv2.AddTextItem("3077	Κατηγορία 9	Επικίνδυνη για το περιβάλλον ουσία, στερεό, NOS δεν συμπεριλαμβάνονται τα απορρίμματα	    " ,"")
   clv2.AddTextItem("3078	Κατηγορία 4.3	Δημήτριο , ρινίσματα ή λιθίαση σκόνη	    " ,"")
   clv2.AddTextItem("3079	Κατηγορία 3	Μεθακρυλονιτρίλ , αναστέλλεται	   " ,"")
   clv2.AddTextItem("3082	Κατηγορία 9	Επικίνδυνη για το περιβάλλον ουσία, υγρό, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3083	Κατηγορία 2.3	Υπερχλωρυλοφθορίδιο	    " ,"")
   clv2.AddTextItem("3084	Κατηγορία 8	Διαβρωτικό στερεά, οξειδωτικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3085	Κατηγορία 5.1	Οξειδωτικό στερεά, διαβρωτικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3086	Κατηγορία 6.1	Τοξικά στερεά, οξειδωτικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3087	Κατηγορία 5.1	Οξειδωτικές στερεές, τοξικές, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3088	Κατηγορία 4.2	Αυτο-θέρμανση στερεά, οργανικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3089	Κατηγορία 4.1	Μέταλλο σε σκόνη, εύφλεκτο, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3090	Κατηγορία 9	Μπαταρίες λιθίου	    " ,"")
   clv2.AddTextItem("3091	Κατηγορία 9	Mπαταρίες λιθίου που περιέχονται στον εξοπλισμό	    " ,"")
   clv2.AddTextItem("3092	Κατηγορία 3	Mεθοξυ-προπανόλη " ,"")	   
   clv2.AddTextItem("3093	Κατηγορία 8	Διαβρωτικό υγρό, οξειδωτικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3094	Κατηγορία 8	Διαβρωτικό υγρό, αντιδρούν με το νερό, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3095	Κατηγορία 8	Διαβρωτικό στερεό, αυτο-θέρμανσης, ε.α.ο.	   " ,"") 
   clv2.AddTextItem("3096	Κατηγορία 8	Διαβρωτικών στερεών, αντιδρούν με το νερό, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3097	Κατηγορία 4.1	Εύφλεκτα στερεά, οξειδωτικά, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3098	Κατηγορία 5.1	Οξειδωτικό υγρό, διαβρωτικό, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3099	Κατηγορία 5.1	Οξειδωτικό υγρό, τοξικό, ε.α.ο.	    " ,"")
   clv2.AddTextItem("3100	Κατηγορία 5.1	Οξειδωτικό στερεό, αυτο-θέρμανσης, ε.α.ο.	  " ,"")

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
	lbl.Gravity = Bit.OR(Gravity.CENTER_VERTICAL, Gravity.LEFT)
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

