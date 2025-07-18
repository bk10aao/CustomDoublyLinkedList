import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower().strip('"') != 'size']

        for row in reader:
            try:
                size = int(row['Size'].strip('"'))
            except (ValueError, KeyError):
                continue
            for header in headers:
                val_str = row.get(header) or row.get(f'"{header}"') or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load all three CSVs
custom_data = read_csv('CustomLinkedList_performance.csv')
doubly_data = read_csv('CustomDoublyLinkedList_performance.csv')
standard_data = read_csv('LinkedList_performance.csv')

# Get common methods between all three
common_methods = sorted(
    set(custom_data.keys())
    .intersection(doubly_data.keys())
    .intersection(standard_data.keys())
)

if not common_methods:
    print("No common methods found across all three datasets.")
    exit()

# Plotting setup
fig, axes = plt.subplots(nrows=len(common_methods), ncols=1, figsize=(12, 4 * len(common_methods)))
if len(common_methods) == 1:
    axes = [axes]

scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)

for idx, method in enumerate(common_methods):
    custom_dict = dict(custom_data[method])
    doubly_dict = dict(doubly_data[method])
    standard_dict = dict(standard_data[method])

    shared_sizes = sorted(
        set(custom_dict.keys()).intersection(doubly_dict.keys()).intersection(standard_dict.keys())
    )
    if not shared_sizes:
        print(f"Skipping method {method}: no shared sizes.")
        continue

    custom_times = [custom_dict[size] for size in shared_sizes]
    doubly_times = [doubly_dict[size] for size in shared_sizes]
    standard_times = [standard_dict[size] for size in shared_sizes]

    ax = axes[idx]
    ax.plot(shared_sizes, custom_times, label='CustomLinkedList', linestyle='-', linewidth=1.5)
    ax.plot(shared_sizes, doubly_times, label='CustomDoublyLinkedList', linestyle='-', linewidth=1.5)
    ax.plot(shared_sizes, standard_times, label='LinkedList', linestyle='-', linewidth=1.5)

    ax.set_title(method)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.grid(True)
    ax.legend()

    x_min, x_max = min(shared_sizes), max(shared_sizes)
    ax.set_xlim(x_min, x_max)

    y_max = max(max(custom_times), max(doubly_times), max(standard_times))
    ax.set_ylim(0, y_max * 1.1 if y_max > 0 else 1)

    # Set x-axis ticks: start at 2500 or rounded nearest, then every 100,000
    x_tick_start = max(2500, x_min)
    x_ticks = list(range((x_tick_start // 100000) * 100000, x_max + 1, 100000))
    if x_tick_start not in x_ticks:
        x_ticks.insert(0, x_tick_start)

    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('CustomLinkedList_vs_CustomDoublyLinkedList_vs_LinkedList_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print("Chart saved as 'CustomLinkedList_vs_CustomDoublyLinkedList_vs_LinkedList_Performance_Comparisons.png'")
