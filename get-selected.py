def get_selected_text(self):
        bounds = self.day_text_buffer.get_selection_bounds()
        if bounds:
            return self.get_text(*bounds)
        else:
            return "" 
print(get_selected_text())