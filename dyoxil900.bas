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

 
clv2.AddTextItem("2801	Κατηγορία 8	Βαφές , υγρά, διαβρωτικά, ε.α.ο. ή Dye ενδιάμεσα, υγρά, διαβρωτικά, ε.α.ο.	   " ,"")    
clv2.AddTextItem("2802	Κατηγορία 8	Χλωριούχου χαλκού	      " ,"") 
clv2.AddTextItem("2803	Κατηγορία 8	Γάλλιο	      " ,"") 
clv2.AddTextItem("2805	Κατηγορία 4.3	Υδρίδιο  λιθίου , συντηγμένο στερεό	      " ,"") 
clv2.AddTextItem("2806	Κατηγορία 4.3	Νιτρίδιο  λιθίου	      " ,"") 
clv2.AddTextItem("2807	Κατηγορία 9	Μαγνητισμένο υλικό	      " ,"") 
clv2.AddTextItem("2809	Κατηγορία 8	Ερμής ή Ερμής που περιέχονται σε βιομηχανικά είδη	      " ,"") 
clv2.AddTextItem("2810	Κατηγορία 6.1	Τοξικό, υγρά, οργανικά, ε.α.ο. ή τοξικές, υγρά, οργανικά, ε.α.ο. Εισπνοή κινδύνου, ομάδα συσκευασίας I, Ζώνη Α ή Β	      " ,"") 
clv2.AddTextItem("2811	Κατηγορία 6.1	Τοξικά στερεά, οργανικά, ε.α.ο.	      " ,"") 
clv2.AddTextItem("2812	Κατηγορία 8	Αργιλικό νάτριο , στερεά	      " ,"") 
clv2.AddTextItem("2813	Κατηγορία 4.3	Αντιδρούν με  νερό στερεά, ε.α.ο.	      " ,"") 
clv2.AddTextItem("2814	Κατηγορία 6.2	Μολυσματική ύλη, που προσβάλλει τον άνθρωπο	      " ,"") 
clv2.AddTextItem("2814	Κατηγορία 6.2	Μολυσματική ύλη, που προσβάλλει τους ανθρώπους (Κινδύνων  Ομίλου Κατηγορία 2).	      " ,"") 
clv2.AddTextItem("2815	Κατηγορία 8	Ν-αμινοαιθυλπιπεραζίνη	      " ,"") 
clv2.AddTextItem("2817	Κατηγορία 8	Hydrogendiflouride αμμώνιο , λύση	      " ,"") 
clv2.AddTextItem("2818	Κατηγορία 8	Πολυσουλφίδιο αμμωνίου , λύση	      " ,"") 
clv2.AddTextItem("2819	Κατηγορία 8	Αμυλεστέρας φωσφορικό οξύ	      " ,"") 
clv2.AddTextItem("2820	Κατηγορία 8	Βουτυρικό οξύ	     " ,"") 
clv2.AddTextItem("2821	Κατηγορία 6.1	Η φαινόλη   " ,"") 
clv2.AddTextItem("2822	Κατηγορία 6.1	Κατηγορία 2-χλωροπυριδίνη	      " ,"") 
clv2.AddTextItem("2823	Κατηγορία 8	Κροτονικού οξέος υγρό ή κροτωνικό οξύ στερεό	    " ,"")   
clv2.AddTextItem("2826	Κατηγορία 8	Ethyl χλωροθειομυρμηκικού	      " ,"") 
clv2.AddTextItem("2829	Κατηγορία 8	Καπροϊκό οξύ	      " ,"") 
clv2.AddTextItem("2830	Κατηγορία 4.3	ΣιδηροπυρΙτιο λιθίου	      " ,"") 
clv2.AddTextItem("2831	Κατηγορία 6.1              Tριχλωροαιθάνιο	      " ,"") 
clv2.AddTextItem("2834	Κατηγορία 8	Φωσφορώδες οξύ	      " ,"") 
clv2.AddTextItem("2835	Κατηγορία 4.3	Νάτριο υδριδίου αργιλίου	      " ,"") 
clv2.AddTextItem("2837	Κατηγορία 8	Διθειικό , υδατικό διάλυμα	      " ,"") 
clv2.AddTextItem("2838	Κατηγορία 3	Βουτυρικό βινύλιο    " ,"")    
clv2.AddTextItem("2839	Κατηγορία 6.1	Αλδολικές	      " ,"") 
clv2.AddTextItem("2840	Κατηγορία 3	Butyraldoxime	    " ,"")    
clv2.AddTextItem("2841	Κατηγορία 3	Δι-κ-αμυλαμίνη	   " ,"")    
clv2.AddTextItem("2842	Κατηγορία 3	Νιτροαιθάνιο	   " ,"")    
clv2.AddTextItem("2844	Κατηγορία 4.3	Ασβέστιο πυριτίου μαγγάνιο	      " ,"") 
clv2.AddTextItem("2845	Κατηγορία 4.2	Πυροφορικά υγρά, οργανικά, ε.α.ο.	   " ,"")    
clv2.AddTextItem("2846	Κατηγορία 4.2	Πυροφορικά στερεά, οργανικά, ε.α.ο.	   " ,"")    
clv2.AddTextItem("2849	Κατηγορία 6.1	Xλωροπροπανόλη	      " ,"") 
clv2.AddTextItem("2850	Κατηγορία 3	Τετραμερές προπυλένιο	   " ,"")    
clv2.AddTextItem("2851	Κατηγορία 8	Βόριο τριφθοριούχο διένυδρο	      " ,"") 
clv2.AddTextItem("2852	Κατηγορία 4.1	Διπικρύλιο σουλφίδιο , βρεγμένο με όχι λιγότερο από 10 τοις εκατό νερό, κατά βάρος	   " ,"")    
clv2.AddTextItem("2853	Κατηγορία 6.1	Φθοριοπυρι μαγνήσιο	      " ,"") 
clv2.AddTextItem("2854	Κατηγορία 6.1	Φθοροπυριτικό αμμώνιο	      " ,"") 
clv2.AddTextItem("2855	Κατηγορία 6.1	Φθοριοπυρι ψευδαργύρου	      " ,"") 
clv2.AddTextItem("2856	Κατηγορία 6.1	Φθοροπυριτικά , ε.α.ο.	      " ,"") 
clv2.AddTextItem("2857	Κατηγορία 2	Ψυκτικές μηχανές , που περιέχουν μη εύφλεκτο, μη τοξικό, υγροποιημένο αέριο ή διάλυμα αμμωνίας (UN2672)	   " ,"")    
clv2.AddTextItem("2858	Κατηγορία 4.1	Ζιρκόνιο , ξηρό, περιτυλιγμένα σύρμα   " ,"") 
clv2.AddTextItem("2859	Κατηγορία 6.1	Μεταβαναδικό αμμώνιο	      " ,"") 
clv2.AddTextItem("2860	Κατηγορία 6.1	Βαναδίου τριοξείδιο	      " ,"") 
clv2.AddTextItem("2861	Κατηγορία 6.1	Polyvanadate αμμώνιο	      " ,"") 
clv2.AddTextItem("2862	Κατηγορία 6.1	Πεντοξείδιο  βαναδίου , άτηκτες μορφή	      " ,"") 
clv2.AddTextItem("2863	Κατηγορία 6.1	Νάτριο βαναδικού αμμωνίου	      " ,"") 
clv2.AddTextItem("2864	Κατηγορία 6.1	Μεταβαναδικό κάλιο	      " ,"") 
clv2.AddTextItem("2865	Κατηγορία 8	Θειικής υδροξυλαμίνης	      " ,"") 
clv2.AddTextItem("2869	Κατηγορία 8	Τριχλωριούχο τιτάνιο μείγματα	    " ,"")   
clv2.AddTextItem("2870	Κατηγορία 4.2	Βοροϋδρίδιο αλουμινίου ή βοροϋδρίδιο αλουμινίου σε συσκευές	   " ,"")    
clv2.AddTextItem("2870	Κατηγορία 4.2	Aluminiumborhydrid σε Gerten	      " ,"") 
clv2.AddTextItem("2871	Κατηγορία 6.1	Αντιμόνιο σε σκόνη	      " ,"") 
clv2.AddTextItem("2872	Κατηγορία 6.1	Dibromochloropropane	    " ,"")   
clv2.AddTextItem("2873	Κατηγορία 6.1	Dibutylaminoethanol	   " ,"")    
clv2.AddTextItem("2874	Κατηγορία 6.1	Φουρφουρυλική αλκοόλ	   " ,"")    
clv2.AddTextItem("2875	Κατηγορία 6.1	Εξαχλωροφαίνιο	      " ,"") 
clv2.AddTextItem("2876	Κατηγορία 6.1	Resorcinol	      " ,"") 
clv2.AddTextItem("2878	Κατηγορία 4.1	Τιτανίου κόκκους ή σκόνες σφουγγάρι σφουγγάρι τιτανίου	    " ,"") 
clv2.AddTextItem("2879	Κατηγορία 8	Σελήνιο οξυχλωριούχου	      " ,"") 
clv2.AddTextItem("2880	Κατηγορία 5.1	Υποχλωριώδες ασβέστιο   " ,"") 
clv2.AddTextItem("2881	Κατηγορία 4.2	Μεταλλικό καταλύτη , ξηρό	      " ,"") 
   clv2.AddTextItem("2900	Κατηγορία 6.2	Μολυσματική ύλη, που προσβάλλει ζώα	    " ,"") 
  

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

