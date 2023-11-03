package view;
import java.beans.PropertyChangeListener;
/* introduces this abstraction for Open Closed Principle. Later when new functionality are added,
please make those viewModels inherit this abstract class, and when you refer to a view Model,
try use this abstract type instead of your concrete view model. (Kelly)
*
* */
    public abstract class ViewModel {

        private String viewName;

        public ViewModel(String viewName) {
            this.viewName = viewName;
        }
        public String getViewName() {
            return this.viewName;
        }

        public abstract void firePropertyChanged();
        public abstract void addPropertyChangeListener(PropertyChangeListener listener);


    }

