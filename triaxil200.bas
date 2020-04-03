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

 

clv2.AddTextItem("3101	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Β, υγρό	  " ,"") 
clv2.AddTextItem("3102	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου B, στερεά	   " ,"") 
clv2.AddTextItem("3103	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου C, υγρά	   " ,"") 
clv2.AddTextItem("3104	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου C, στερεά	   " ,"") 
clv2.AddTextItem("3105	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου D, υγρά	   " ,"") 
clv2.AddTextItem("3106	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου D, στερεά	   " ,"") 
clv2.AddTextItem("3107	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Ε, υγρά	   " ,"") 
clv2.AddTextItem("3108	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Ε, στερεό	   " ,"") 
clv2.AddTextItem("3109	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου F, υγρό	   " ,"") 
clv2.AddTextItem("3110	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου F, στερεά	   " ,"") 
clv2.AddTextItem("3111	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Β, ελεγχόμενη υγρό, θερμοκρασία	   " ,"") 
clv2.AddTextItem("3112	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Β, ελέγχονται στερεά, θερμοκρασία	" ,"")    
clv2.AddTextItem("3113	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου C, ελεγχόμενη υγρό, θερμοκρασία	   " ,"") 
clv2.AddTextItem("3114	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου C, που ελέγχονται στερεά, θερμοκρασία	  " ,"")  
clv2.AddTextItem("3115	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου D, που ελέγχεται υγρό, θερμοκρασία	" ,"")    
clv2.AddTextItem("3116	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου D, που ελέγχονται στερεά, θερμοκρασία	   " ,"") 
clv2.AddTextItem("3117	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Ε, ελεγχόμενη υγρό, θερμοκρασία	   " ,"") 
clv2.AddTextItem("3118	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου Ε, στερεά ελεγχόμενη, θερμοκρασία	 " ,"")   
clv2.AddTextItem("3119	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου F, ελεγχόμενη υγρό, θερμοκρασία	   " ,"") 
clv2.AddTextItem("3120	Κατηγορία 5.2	Οργανικό υπεροξείδιο τύπου F, στερεά ελεγχόμενη, θερμοκρασία	" ,"")    
clv2.AddTextItem("3121	Κατηγορία 5.1	Οξειδωτικό στερεό, αντιδρούν με το νερό, 	" ,"")      
clv2.AddTextItem("3124	Κατηγορία 6.1	Τοξικά στερεά, αυτοθερμαινόμενα, 	   " ,"") 
clv2.AddTextItem("3125	Κατηγορία 6.1	Τοξικά στερεά, αντιδρούν με το νερό, 	   " ,"") 
clv2.AddTextItem("3126	Κατηγορία 4.2	Αυτο-θέρμανσης στερεά, διαβρωτικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3127	Κατηγορία 4.2	Αυτο-θέρμανση στερεά, οξειδωτικά, 	   " ,"") 
clv2.AddTextItem("3128	Κατηγορία 4.2	Αυτο-θέρμανσης στερεά, τοξικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3129	Κατηγορία 4.3	Αντιδρούν με το νερό υγρά, διαβρωτικά, 	   " ,"") 
clv2.AddTextItem("3130	Κατηγορία 4.3	Αντιδρούν με το νερό υγρά, τοξικά, 	   " ,"") 
clv2.AddTextItem("3131	Κατηγορία 4.3	Αντιδρούν με το νερό στερεά, διαβρωτικά, 	  " ,"") 
clv2.AddTextItem("3132	Κατηγορία 4.3	Αντιδρούν με το νερό στερεά, εύφλεκτα, 	   " ,"") 
clv2.AddTextItem("3133	Κατηγορία 4.3	Αντιδρούν με το νερό στερεά, oxidixing, 	   " ,"") 
clv2.AddTextItem("3134	Κατηγορία 4.3	Αντιδρούν με το νερό στερεά, τοξικά, 	   " ,"") 
clv2.AddTextItem("3135	Κατηγορία 4.3	Αντιδρούν με το νερό στερεά, αυτοθερμαινόμενα,    " ,"") 
clv2.AddTextItem("3136	Κατηγορία 2.2	Τριφθορομεθάνη , κατεψυγμένο, υγρό	   " ,"") 
clv2.AddTextItem("3137	Κατηγορία 5.1	Οξειδωτικό στερεό, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3138	Κατηγορία 2.1	Αιθυλένιο, ακετυλένιο και προπυλένιο" ,"") 
clv2.AddTextItem("3139	Κατηγορία 5.1	Οξειδωτικό υγρό, 	   " ,"") 
clv2.AddTextItem("3140	Κατηγορία 6.1	Αλκαλοειδή , υγρό,  ή αλκαλοειδή άλατα, υγρά, 	" ,"")    
clv2.AddTextItem("3141	Κατηγορία 6.1	Αντιμόνιο ένωση, ανόργανα, υγρό, 	   " ,"") 
clv2.AddTextItem("3142	Κατηγορία 6.1	Απολυμαντικό , υγρό, τοξικό, 	   " ,"") 
clv2.AddTextItem("3143	Κατηγορία 6.1	Dye , στερεά, τοξικά,  ή ενδιάμεση βαφή, στερεά, τοξικά, " ,"") 	   
clv2.AddTextItem("3144	Κατηγορία 6.1	Η νικοτίνη ένωση, υγρό,  ή νικοτίνη προετοιμασία, υγρό, 	  " ,"")  
clv2.AddTextItem("3145	Κατηγορία 8	Αλκυλοφαινόλες , υγρές,  συμπεριλαμβανομένων C2-C12 ομολόγων" ,"") 	   
clv2.AddTextItem("3146	Κατηγορία 6.1	Οργανοκασσιτερικές ενώσεις, στερεές, 	   " ,"") 
clv2.AddTextItem("3147	Κατηγορία 8	Dye, στερεά, διαβρωτικά,  ή ενδιάμεση βαφή, στερεά, διαβρωτικά, 	" ,"")    
clv2.AddTextItem("3148	Κατηγορία 4.3	Αντιδρούν με το νερό υγρά,	   " ,"") 
clv2.AddTextItem("3149	Κατηγορία 5.1	Υπεροξείδιο του υδρογόνου και υπεροξικό οξύ" ,"") 
clv2.AddTextItem("3151	Κατηγορία 9	Πολυαλογονωμένα διφαινύλια , υγρά ή πολυαλογονωμένα τερφαινύλια , υγρά" ,"") 	   
clv2.AddTextItem("3152	Κατηγορία 9	Πολυαλογονωμένα διφαινύλια, στερεά ή πολυαλογονωμένα τερφαινύλια, στερεά	" ,"")    
clv2.AddTextItem("3153	Κατηγορία 2.1	Υπερφθορο μεθυλ βινυλ αιθέρας)	   " ,"") 
clv2.AddTextItem("3154	Κατηγορία 2.1	Υπερφθορο αιθυλ βινυλαιθέρα)	   " ,"") 
clv2.AddTextItem("3155	Κατηγορία 6.1	Πενταχλωροφαινόλη	   " ,"") 
clv2.AddTextItem("3156	Κατηγορία 2.2	Συμπιεσμένο αέριο , οξειδωτικά, 	  " ,"")  
clv2.AddTextItem("3157	Κατηγορία 2.2	Υγροποιημένο αέριο , οξειδωτικά, 	   " ,"") 
clv2.AddTextItem("3158	Κατηγορία 2.2	Αερίου, ψυγείο υγρό, NOS κρυογονική υγρό	" ,"")    
clv2.AddTextItem("3159	Κατηγορία 2.2	Τετραφθοροαιθάνιο ή το ψυκτικό αέριο R 134a	 " ,"")   
clv2.AddTextItem("3160	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά, εύφλεκτα,  Εισπνοή κινδύνου Ζώνη Α, Β, Γ ή Δ	" ,"")    
clv2.AddTextItem("3161	Κατηγορία 2.1	Υγροποιημένο αέριο, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3162	Κατηγορία 2.3	Υγροποιημένα αέρια, τοξικά,  Εισπνοή κινδύνου Ζώνη Α, Β, Γ ή Δ	" ,"")    
clv2.AddTextItem("3163	Κατηγορία 2.2	Υγροποιημένο αέριο, 	   " ,"") 
clv2.AddTextItem("3164	Κατηγορία 2.2	Άρθρα, πίεση αέρα ή υδραυλική που περιέχουν άφλεκτο αέριο	" ,"")    
clv2.AddTextItem("3165	Κατηγορία 3	Δεξαμενή καυσίμων αεροσκαφών	   " ,"") 
clv2.AddTextItem("3166	Κατηγορία 9	Κινητήρες εσωτερικής καύσης" ,"") 
clv2.AddTextItem("3167	Κατηγορία 2.1	Δείγμα αερίου, χωρίς πίεση, εύφλεκτο, , υγρό όχι υπό ψύξη	   " ,"") 
clv2.AddTextItem("3168	Κατηγορία 2.3	Δείγμα αερίου, χωρίς πίεση, τοξικά, εύφλεκτα, , υγρό όχι υπό ψύξη	" ,"")    
clv2.AddTextItem("3169	Κατηγορία 2.3	Δείγμα αερίου, χωρίς πίεση, τοξικά, , υγρό όχι υπό ψύξη	   " ,"") 
clv2.AddTextItem("3170	Κατηγορία 4.3	Αλουμίνιο τήξης υποπροϊόντα ή ανάτηξη αλουμινίου υποπροϊόντα ή αλουμίνιο Dross	   " ,"") 
clv2.AddTextItem("3171	Κατηγορία 9	Όχημα που λειτουργούν με μπαταρίες ή με μπαταρίες εξοπλισμό	   " ,"") 
clv2.AddTextItem("3172	Κατηγορία 6.1	Τοξίνες, που εξάγεται από ζωντανές πηγές, υγρό, 	      " ,"") 
clv2.AddTextItem("3174	Κατηγορία 4.2	Τιτανίου δισουλφιδίου	   " ,"") 
clv2.AddTextItem("3175	Κατηγορία 4.1	Στερεά που περιέχουν εύφλεκτο υγρό, 	   " ,"") 
clv2.AddTextItem("3176	Κατηγορία 4.1	Εύφλεκτα στερεά, οργανικά, λιωμένο, 	      " ,"") 
clv2.AddTextItem("3178	Κατηγορία 4.1	Εύφλεκτα στερεά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3179	Κατηγορία 4.1	Εύφλεκτα στερεά, τοξικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3180	Κατηγορία 4.1	Εύφλεκτα στερεά, διαβρωτικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3181	Κατηγορία 4.1	Τα μεταλλικά άλατα  οργανικών ενώσεων, εύφλεκτα, 	   " ,"") 
clv2.AddTextItem("3182	Κατηγορία 4.1	Μεταλλικά υδρίδια, εύφλεκτο, 	   " ,"") 
clv2.AddTextItem("3183	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, οργανικά, 	   " ,"") 
clv2.AddTextItem("3184	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, τοξικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3185	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, διαβρωτικά, οργανικά, 	   " ,"") 
clv2.AddTextItem("3186	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3187	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, τοξικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3188	Κατηγορία 4.2	Υγρό Αυτο-θέρμανσης, διαβρωτικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3189	Κατηγορία 4.2	Μέταλλο σε σκόνη, αυτο-θέρμανσης, 	   " ,"") 
clv2.AddTextItem("3190	Κατηγορία 4.2	Αυτο-θέρμανση στερεά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3191	Κατηγορία 4.2	Αυτο-θέρμανση στερεά, τοξικά, ανόργανα, 	   " ,"") 
clv2.AddTextItem("3192	Κατηγορία 4.2	Αυτο-θέρμανση στερεά, διαβρωτικά, ανόργανα, 	      " ,"") 
clv2.AddTextItem("3194	Κατηγορία 4.2	Πυροφορικό υγρό, ανόργανα, 	   " ,"") 
   clv2.AddTextItem("3200	Κατηγορία 4.2	Πυροφορικό στερεά, ανόργανα, 	 " ,"") 






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
